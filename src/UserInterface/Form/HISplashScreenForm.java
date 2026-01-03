package UserInterface.Form;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import UserInterface.HIIAStyle;

public abstract class HISplashScreenForm {
    private static JFrame       frmSplash;
    private static JProgressBar prbLoading;
    private static ImageIcon    icoImage;
    private static JLabel       lblSplash;

    public static void show() {
        icoImage = new ImageIcon(HIIAStyle.URL__SPLASH);
        lblSplash = new JLabel(icoImage);
        prbLoading = new JProgressBar(0, 100);

        prbLoading.setStringPainted(true);

        frmSplash = new JFrame();
        frmSplash.setUndecorated(true); //quito bordes
        frmSplash.getContentPane().add(lblSplash, BorderLayout.CENTER);//agrego la imagen al centro
        frmSplash.add(prbLoading, BorderLayout.SOUTH);// agrego la barra de progreso en la parte inferior
        frmSplash.setSize(icoImage.getIconWidth(), icoImage.getIconHeight()); //ajusto el tamaño del frame al tamaño de la imagen
        frmSplash.setLocationRelativeTo(null);//centro en la mitad de la pantalla
        
        frmSplash.setVisible(true); //muestro el frame
        for(int i = 0; i <= 100; i+=10){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prbLoading.setValue(i);
        }
        frmSplash.setVisible(false);

        
    }

}
