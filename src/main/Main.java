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
        if (args[0].equals("newTest")) {
            NewTest.INSTANCE.setVisible(true);
        } else {
            Start.INSTANCE.setVisible(true);
        }
    }

}
