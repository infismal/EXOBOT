package DataAccess.DTO;

public class SexoDTO {

    private Integer IdCatalogo     ;
    private Integer IdCatalogoTipo ;
    private String  Nombre         ;
    private String  Descripcion    ;
    private String  Estado         ;
    private String  FechaCreacion  ;
    private String  FechaModifica  ;
    


    public SexoDTO (){}
    
    public SexoDTO(Integer idCatalogo, Integer idCatalogoTipo, String nombre, String descripcion, String estado,
            String fechaCreacion, String fechaModifica) {
        IdCatalogo = idCatalogo;
        IdCatalogoTipo = idCatalogoTipo;
        Nombre = nombre;
        Descripcion = descripcion;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

        public Integer getIdCatalogo() {
        return IdCatalogo;
    }

    public void setIdCatalogo(Integer idCatalogo) {
        IdCatalogo = idCatalogo;
    }

    public Integer getIdCatalogoTipo() {
        return IdCatalogoTipo;
    }

    public void setIdCatalogoTipo(Integer idCatalogoTipo) {
        IdCatalogoTipo = idCatalogoTipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString(){

        return  "\n getClass().getName()" // me devuelve el paquete donde está y el nombre de la clase (lo ocupo para verificar que se este copiando lo que debe copiarse)
              + "\n IdCatalogo:       "    +getIdCatalogo()
              + "\n IdCatalogoTipo:   "    +getIdCatalogoTipo()
              + "\n Nombre:           "    +getNombre()
              + "\n Descripcion:      "    +getDescripcion()
              + "\n Estado:           "    +getEstado()
              + "\n FechaCreacion:    "    +getFechaCreacion()
              + "\n FechaModifica:    "    +getFechaModifica();

    }

    








    



}
