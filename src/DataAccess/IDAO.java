package DataAccess;

import java.util.List; //Me pide una entidad en especifico con la cual trabajará.

public interface IDAO <T> { 

    public boolean HICreate (T entity)        throws Exception;
    public List<T> HIReadAll ()               throws Exception;
    public boolean HIUpdate (T entity)        throws Exception;
    public boolean HIDelete (Integer id)      throws Exception;
    public T HIReadBy(Integer id)             throws Exception;

}