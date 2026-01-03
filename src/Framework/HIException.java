package Framework;

public class HIException extends Exception{

    public HIException(String e, String clase, String metodo){
        //grabar el lig
        //System.out.println("[ERROR APP --> LOG] " + clase + "." + metodo + " : " + e);
    }

    @Override
    public String getMessage(){
        return "NO sea sapo..";
    }

}
