package main;

import gui.NewTest;
import gui.Start;

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
        if (args[0].equals("newTest")) {
            NewTest.getInstance().setVisible(true);
        } else if (args[0].equals("start")) {
            Start.INSTANCE.setVisible(true);
        } else {
            System.err.println("Select a valid project configuration");
        }
    }

}
