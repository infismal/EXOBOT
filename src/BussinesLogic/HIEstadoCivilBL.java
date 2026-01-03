package BussinesLogic;

import java.util.List;

import DataAccess.HIEstadoCivilDAO;
import DataAccess.DTO.EstadoCivilDTO;

public class HIEstadoCivilBL {

    private EstadoCivilDTO ecDTO;
    private HIEstadoCivilDAO esDAO = new HIEstadoCivilDAO();

    public HIEstadoCivilBL(){}

    public List<EstadoCivilDTO> HIGetAll() throws Exception {
        List<EstadoCivilDTO> lst = esDAO.HIReadAll();
        for(EstadoCivilDTO estadoCivil : lst)
            estadoCivil.setNombre(estadoCivil.getNombre().toUpperCase());
        return lst;
    }
    
    public EstadoCivilDTO HIGetBy(int idEstadoCivil) throws Exception{
        ecDTO = esDAO.HIReadBy(idEstadoCivil);
        return ecDTO;
    }

    public boolean HIAdd(EstadoCivilDTO regDTO) throws Exception{
        return esDAO.HICreate(regDTO);
    }

    public boolean HIUpdate(EstadoCivilDTO regDTO) throws Exception{
        return esDAO.HIUpdate(regDTO);
    }

    public boolean HIDelete(int regDTO) throws Exception{
        return esDAO.HIDelete(regDTO);
    }

    public Integer HIGetRowCount() throws Exception{
        return esDAO.HIGetCountRow();
    }

}