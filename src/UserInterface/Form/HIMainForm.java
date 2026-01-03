package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HIMainForm extends JFrame { //al extender de JFrame, esta clase ya es un formulario
    JPanel pnlMenu = new JPanel();
    JPanel pnlMain = new JPanel();

    public MainForm(String titleApp) {
        customizeComponent(titleApp);
        pnlMenu.btnHome.addActionListener(e -> setPanel(new JPanel()));
        pnlMenu.btnLogin.addActionListener(e -> setPanel(new JPanel()));
        pnlMenu.btnSexo.addActionListener(e -> setPanel(new JPanel()));
        pnlMenu.btnLocalidad.addActionListener(e -> setPanel(new JPanel()));
        // agregar
        pnlMenu.btnTest.addActionListener(e -> {IAStyle.showMsgError("mensaje de error");});
    
    }

    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain);
        pnlMain = formularioPanel;
        container.add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void customizeComponent(String titleApp) {
        setTitle(titleApp);
        setSize(930, 800);
        setResizable(false);
        setLocationRelativeTo(null); //centrar en la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Crear un contenedor para los dos paneles usando BorderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Afregar los paneles al contenedor
        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);
        setVisible(true);
    }


    

}
