package BussinesLogic;

import java.util.List;

import DataAccess.HIPersonaTipoDAO;
import DataAccess.DTO.PersonaTipoDTO;

public class HIPersonaTipoBL {

    private PersonaTipoDTO ptDTO;
    private HIPersonaTipoDAO ptDAO = new HIPersonaTipoDAO();

    public HIPersonaTipoBL(){}

    public List<PersonaTipoDTO> HIGetAll() throws Exception {
        return ptDAO.HIReadAll();
    }
    
    public PersonaTipoDTO HIGetBy(int idPersonaTipo) throws Exception{
        ptDTO = ptDAO.HIReadBy(idPersonaTipo);
        return ptDTO;
    }

    public boolean HIAdd(PersonaTipoDTO regDTO) throws Exception{
        return ptDAO.HICreate(regDTO);
    }

    public boolean HIUpdate(PersonaTipoDTO regDTO) throws Exception{
        return ptDAO.HIUpdate(regDTO);
    }

    public boolean HIDelete(int idPersonaTipo) throws Exception{
        return ptDAO.HIDelete(idPersonaTipo);
    }

    public Integer HIGetRowCount() throws Exception{
        return ptDAO.HIGetCountRow();
    }

}