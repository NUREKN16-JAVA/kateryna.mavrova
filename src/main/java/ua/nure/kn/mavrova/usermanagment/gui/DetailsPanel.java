package main.java.ua.nure.kn.mavrova.usermanagment.gui;

import ua.nure.kn.mavrova.usermanagment.User;
import ua.nure.kn.mavrova.usermanagment.db_2.DatabaseException;
import ua.nure.kn.mavrova.usermanagment.utils.Messages;
import ua.nure.kn.mavrova.usermanagment.gui.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DetailsPanel extends CustomPanel {

    JPanel infoPanel;
    JPanel buttonsPanel;

    JButton okButton;

    MainFrame parent;

    Long userId;

    DetailsPanel(MainFrame parent) {
        this.parent = parent;
        initialize();
    }

    public void setId(Long userId) {
        this.userId = userId;
        this.add(getInfoPanel(), BorderLayout.NORTH);
    }

    private void initialize() {
        this.setName("detailsPanel");
        this.setLayout(new BorderLayout());
        //this.add(getInfoPanel(), BorderLayout.NORTH);
        this.add(getButtonsPanel(), BorderLayout.SOUTH);
    }

    private JPanel getInfoPanel() {
        if (infoPanel == null) {
            infoPanel = new JPanel();
            infoPanel.setLayout(new GridLayout(4, 2));

            try {
                User user = parent.getDao().find(userId);
                infoPanel.add(new JLabel(Messages.getString("id")));
                infoPanel.add(new JLabel(((User) user).getId().toString()));
                infoPanel.add(new JLabel(Messages.getString("firstname")));
                infoPanel.add(new JLabel(user.getFirstName()));
                infoPanel.add(new JLabel(Messages.getString("lastname")));
                infoPanel.add(new JLabel(user.getLastName()));
                infoPanel.add(new JLabel(Messages.getString("dateofbirth")));
                infoPanel.add(new JLabel(user.getDateOfBirth().toString()));

            } catch (DatabaseException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), Messages.getString("error"), JOptionPane.ERROR_MESSAGE);
            }

        }
        return infoPanel;
    }

    private JPanel getButtonsPanel() {
        if (buttonsPanel == null) {
            buttonsPanel = new JPanel();
            buttonsPanel.add(okButton = makeButton(okButton, Messages.getString("ok"), "ok"));
        }
        return buttonsPanel;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("ok")) {
            this.setVisible(false);
            parent.showBrowsePanel();
        }
    }
}