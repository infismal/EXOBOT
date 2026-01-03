import java.awt.SplashScreen;

import BussinesLogic.HIEstadoCivilBL;
import BussinesLogic.HIPersonaTipoBL;
import BussinesLogic.HISexoBL;
import DataAccess.HIEstadoCivilDAO;
import DataAccess.HIPersonaTipoDAO;
import DataAccess.HISexoDAO;
import DataAccess.DTO.EstadoCivilDTO;
import DataAccess.DTO.PersonaTipoDTO;
import DataAccess.DTO.SexoDTO;
import UserInterface.Form.HIMainForm;
import UserInterface.Form.HISplashScreenForm;

public class App {
    public static void main(String[] args) throws Exception {

        //testing : DAO
        try {
            HISexoDAO hiSexoDao = new HISexoDAO();
            for(SexoDTO s : hiSexoDao.HIReadAll())
                System.out.println(s.toString());

            

        HISplashScreenForm.show();
        HIMainForm hiMainForm = new HIMainForm();
        
        } catch (Exception e) {
            System.out.println(e.toString());
        }

          
            // testing : DAO
            // try {      
            //     int a[] = {10,0}, b = 10;
            //     try {
            //         int resultadoA = a[100]/2;
            //         int resultado = a[1]/b;
            //     } 
            //     catch (ArithmeticException e) {
            //         System.out.println("Error, has dividido por 0... " + e.getMessage());
            //     }
            //     catch(ArrayIndexOutOfBoundsException e){
            //         System.out.println("Error, indice fuera de rango... " + e.getMessage());

            //     }
            //     catch(Exception e){
            //         System.out.println("Ocurrió una excepción " + e.getMessage());
            //     } 
            //     finally {
            //         System.out.println("Finally: Ejecucion con o sin error ");
            //     }
                
            //     HISexoBL hiSexoBL = new HISexoBL();
            //     hiSexoBL.HIAdd(new SexoDTO(0, 0, "Sexo segundo", "prueba de cambio", null, null, null));
            //     for(SexoDTO s : hiSexoBL.HIGetAll()) // hiSexoBL.HIGetAll() se encarga de pasarme una lista, con el for, digo que tome cada elemento de esa lista y lo ponga en s
            //         System.out.println(s.toString()); // y luego imprimo s que es cada elemento de la lista, en cada repeticion se muestra uno distinto
                
            //     System.out.println("-----------------------------------");
            //     HIEstadoCivilBL hiEcBL = new HIEstadoCivilBL();
            //     for(EstadoCivilDTO reg : hiEcBL.HIGetAll())
            //         System.out.println(reg.toString());

            //     System.out.println("-----------------------------------");
            //     HIPersonaTipoBL hiPtBL = new HIPersonaTipoBL();
            //     for(PersonaTipoDTO reg : hiPtBL.HIGetAll())
            //         System.out.println(reg.toString());

            // } 
            // catch (Exception e) {
            //     System.out.println(e.toString());
            // }
    }
}