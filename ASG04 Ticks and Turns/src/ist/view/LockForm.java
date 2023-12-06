package ist.view;

import javax.swing.*;

public class LockForm {
    private JPanel myPanel;
    private JLabel lockStatusViewLabel;
    private JLabel currentTickValueLabel;
    private JButton leftButton;
    private JButton rightButton;
    private JButton pullButton;
    private JButton resetButton;


    public JPanel getMyPanel() {
        return myPanel;
    }

    public JLabel getLockStatusViewLabel() {
        return lockStatusViewLabel;
    }

    public JLabel getCurrentTickValueLabel() {
        return currentTickValueLabel;
    }

    public JButton getLeftButton() {
        return leftButton;
    }

    public JButton getRightButton() {
        return rightButton;
    }

    public JButton getPullButton() {
        return pullButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }
}
