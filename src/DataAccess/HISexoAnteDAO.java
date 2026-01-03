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

public class HISexoAnteDAO extends HISQLiteDataHelper implements IDAO<SexoAnteDTO>{

    @Override
    public SexoAnteDTO HIReadBy (Integer id) throws Exception{
        SexoAnteDTO oS = new SexoAnteDTO();

        String query = " SELECT     IdSexo          "
                     + " ,Nombre                    "
                     + " ,Estado                    "
                     + " ,FechaCrea                 "
                     + " ,FechaModifica             "
                     + " FROM       SEXO            "
                     + " WHERE      Estado ='A' AND IdSexo =  " + id.toString(); 

        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                oS = new SexoAnteDTO( rs.getInt(1)
                                ,rs.getString(2)
                                ,rs.getString(3)
                                ,rs.getString(4)
                                ,rs.getString(5));
            }
        }
        catch(SQLException e){
            throw e;
        }
        return oS;

    }

    @Override
    public List<SexoAnteDTO> HIReadAll () throws Exception {
        List <SexoAnteDTO> lst = new ArrayList<>();
        String query = " SELECT     IdSexo          "
                     + " ,Nombre                    "
                     + " ,Estado                    "
                     + " ,FechaCrea                 "
                     + " ,FechaModifica             "
                     + " FROM       SEXO            "
                     + " WHERE      Estado = 'A'    ";

        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                SexoAnteDTO s = new SexoAnteDTO( rs.getInt(1)
                                        ,rs.getString(2)
                                        ,rs.getString(3)
                                        ,rs.getString(4)
                                        ,rs.getString(5));
                lst.add(s);
            }
        }
        catch(SQLException e){
            throw e;
        }
        return lst;

    }

    @Override
    public boolean HICreate (SexoAnteDTO entity) throws Exception{
        
        String query = "INSERT INTO SEXO (Nombre) VALUES(?)";
        try{
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){
            throw e;
        }
    }

    @Override
    public boolean HIUpdate (SexoAnteDTO entity) throws Exception{

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE SEXO SET Nombre = ?, FechaModifica = ? WHERE IdSexo = ?";
        try{
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdSexo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e){
            throw e;
        }
        
    }

    @Override
    public boolean HIDelete (Integer id) throws Exception{

        String query = " UPDATE SEXO SET Estado = ? WHERE IdSexo = ?";
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

    public Integer HIGetMaxRow() throws Exception {

        String query = " SELECT COUNT(*) TotalReg FROM SEXO "
                     + " WHERE      Estado = 'A' ";
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