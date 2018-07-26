package drivers;

import gui.Start;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author David Vazquez
 */
public class StartDriver implements ActionListener {

    private Start v;

    public StartDriver(Start view) {
        v = view;
        loadListeners();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(v.getNewTest())) {
            System.out.println("nuevo test!");
        } else if (e.getSource().equals(v.getMyData())) {
            System.out.println("mis datooos");
        } else if (e.getSource().equals(v.getPrefs())) {
            System.out.println("mis preferencias");
        }
    }

    private void loadListeners() {
        v.getNewTest().addActionListener(this);
        v.getMyData().addActionListener(this);
        v.getPrefs().addActionListener(this);
    }
}
