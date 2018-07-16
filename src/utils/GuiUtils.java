package utils;

import java.awt.Image;
import javax.swing.JFrame;

/**
 *
 * @author David Vazquez
 */
public class GuiUtils {

    public static int WINDOWS_BAR_HEIGHT = 0;
    //TODO declarar constante con icono de aplicacion

    public static void configuraFrame(JFrame jFrame) {
        jFrame.setSize(jFrame.getPreferredSize().width, jFrame.getPreferredSize().height + WINDOWS_BAR_HEIGHT);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        //TODO icono al jFrame
    }

}
