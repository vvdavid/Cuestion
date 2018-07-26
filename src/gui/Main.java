package gui;

/**
 *
 * @author David Vazquez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        com.alee.laf.WebLookAndFeel.install();
        Start.INSTANCE.setVisible(true);
    }

}
