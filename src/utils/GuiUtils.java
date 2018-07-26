package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author David Vazquez
 */
public class GuiUtils {

    public static final int WINDOWS_BAR_HEIGHT = 0;
    //TODO corregir el tamano del arreglo, debe ser el total de archivos en carpeta
    public static final BufferedImage[] ICONS = new BufferedImage[4];

    static {
        try {
            //TODO asignar valores a cada elemento del arreglo de acuerdo a cada archivo en carpeta
            ICONS[0] = ImageIO.read(GuiUtils.class.getResourceAsStream("/res/appico/ico16.png"));
            ICONS[1] = ImageIO.read(GuiUtils.class.getResourceAsStream("/res/appico/ico32.png"));
            ICONS[2] = ImageIO.read(GuiUtils.class.getResourceAsStream("/res/appico/ico64.png"));
            ICONS[3] = ImageIO.read(GuiUtils.class.getResourceAsStream("/res/appico/ico128.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static void initJFrame(JFrame jFrame) {
        com.alee.laf.WebLookAndFeel.install();
        jFrame.setSize(jFrame.getPreferredSize().width, jFrame.getPreferredSize().height + WINDOWS_BAR_HEIGHT);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setIconImages(Arrays.asList(ICONS));
    }

    public static void open(JFrame oldJFrame, JFrame newJFrame) {
        oldJFrame.dispose();
        newJFrame.setVisible(true);
    }

}
