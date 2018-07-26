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
public class NewTestDriver implements ActionListener {

    private NewTest v;

    public NewTestDriver(NewTest view) {
        v = view;
        loadListeners();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(v.getGoBackButton())) {
            GuiUtils.open(v, Start.INSTANCE);
        } else if (e.getSource().equals(v.getStartTest())) {
            System.err.println("empezar test!");
        }
    }

    private void loadListeners() {
        v.getGoBackButton().addActionListener(this);
        v.getStartTest().addActionListener(this);
    }
}
