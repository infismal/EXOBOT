package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.SexoAnteDTO;
import DataAccess.DTO.SexoDTO;

public class HISexoDAO extends HISQLiteDataHelper implements IDAO<SexoDTO>{

    @Override
    public boolean HICreate(SexoDTO entity) throws Exception {
        String query = "INSERT INTO Catalogo (   IdCatalogoTipo, Nombre, Descripcion  )  VALUES(?, ?, ?)";
        try{
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 2);
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getDescripcion());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){
            throw e;
        }
    }

    @Override
    public List<SexoDTO> HIReadAll () throws Exception {
        List <SexoDTO> lst = new ArrayList<>();
        String query = " SELECT     IdCatalogo      "
                     + " ,IdCatalogoTipo            "
                     + " ,Nombre                    "
                     + " ,Descripcion               "
                     + " ,Estado                    "
                     + " ,FechaCreacion             "
                     + " ,FechaModifica             "
                     + " FROM       CATALOGO        "
                     + " WHERE      Estado = 'A'    "
                     + " AND IdCatalogoTipo = 2     ";

        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                SexoDTO s = new SexoDTO( rs.getInt(1)
                                        ,rs.getInt(2)
                                        ,rs.getString(3)
                                        ,rs.getString(4)
                                        ,rs.getString(5)
                                        ,rs.getString(6)
                                        ,rs.getString(7));
                lst.add(s);
            }
        }
        catch(SQLException e){
            throw e;
        }
        return lst;
    }

    @Override
    public boolean HIUpdate (SexoDTO entity) throws Exception{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Catalogo SET Nombre = ?, Descripcion = ?, FechaModifica = ? WHERE IdCatalogo = ?";
        try{
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getDescripcion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdCatalogo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e){
            throw e;
        }
    }

    @Override
    public boolean HIDelete(Integer id) throws Exception {
        String query = " UPDATE Catalogo SET Estado = ? WHERE IdCatalogo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw e;
        }
    }

    @Override
    public SexoDTO HIReadBy(Integer id) throws Exception {
        SexoDTO s = new SexoDTO();
        String query = " SELECT     IdCatalogo      "
                     + " ,IdCatalogoTipo            "
                     + " ,Nombre                    "
                     + " ,Descripcion               "
                     + " ,Estado                    "
                     + " ,FechaCreacion             "
                     + " ,FechaModifica             "
                     + " FROM       CATALOGO        "
                     + " WHERE      Estado = 'A'    "
                     + " AND IdCatalogoTipo = 2     "
                     + " AND IdCatalogo =" + id.toString();

        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                s = new SexoDTO( rs.getInt(1)
                                ,rs.getInt(2)
                                ,rs.getString(3)
                                ,rs.getString(4)
                                ,rs.getString(5)
                                ,rs.getString(6)
                                ,rs.getString(7));
            }
        }
        catch(SQLException e){
            throw e;
        }
        return s;
    }

    public Integer HIGetCountRow() throws Exception {
        String query =  " SELECT COUNT(*) TotalReg                        "
                       +" FROM Catalogo                                  "
                       +" WHERE Estado = 'A' AND IdCatalogoTipo = 2      " ;
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                return rs.getInt(1);
            }
        }
        catch(SQLException e){
            throw e;
        }
        return 0;
    }
}