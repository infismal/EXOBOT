package BussinesLogic;

import java.util.List;

import DataAccess.HISexoDAO;
import DataAccess.DTO.SexoDTO;

public class HISexoBL {

    private SexoDTO sexo;
    private HISexoDAO sDAO = new HISexoDAO();

    public HISexoBL(){}

    public List<SexoDTO> HIGetAll() throws Exception {
        List<SexoDTO> lst = sDAO.HIReadAll();
        for(SexoDTO sexoDTO : lst)
            sexoDTO.setNombre(sexoDTO.getNombre().toUpperCase());
        return lst;
    }
    
    public SexoDTO HIGetBy(int idSexo) throws Exception{
        sexo = sDAO.HIReadBy(idSexo);
        return sexo;
    }

    public boolean HIAdd(SexoDTO sexoDTO) throws Exception{
        return sDAO.HICreate(sexoDTO);
    }

    public boolean HIUpdate(SexoDTO sexoDTO) throws Exception{
        return sDAO.HIUpdate(sexoDTO);
    }

    public boolean HIDelete(int idSexo) throws Exception{
        return sDAO.HIDelete(idSexo);
    }

    public Integer HIGetRowCount() throws Exception{
        return sDAO.HIGetCountRow();
    }

}