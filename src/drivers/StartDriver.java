package drivers;

import gui.NewTest;
import gui.Start;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.GuiUtils;

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
            GuiUtils.open(v, new NewTest());
        } else if (e.getSource().equals(v.getHistory())) {
            System.err.println("Mis datoos");
        } else if (e.getSource().equals(v.getPrefs())) {
            System.err.println("mis preferecias");
        }
    }

    private void loadListeners() {
        v.getNewTest().addActionListener(this);
        v.getHistory().addActionListener(this);
        v.getPrefs().addActionListener(this);
    }
}
