package drivers;

import db.daos.CategoryDAO;
import gui.CategoryPanel;
import gui.NewTest;
import gui.Start;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import utils.GuiUtils;

/**
 *
 * @author David Vazquez
 */
public class NewTestDriver implements ActionListener {

    private final NewTest v;

    public NewTestDriver(NewTest view) {
        v = view;
        loadListeners();
        DefaultTableModel dt = CategoryDAO.loadTable();
        for (int i = 0; i < dt.getRowCount(); i++) {
            CategoryPanel catPanel = new CategoryPanel();
            view.getPanel().add(new CategoryPanel());
        }
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
