package edu.psu.ist.view;

import javax.swing.*;

public class SplitListForm {
    private JLabel listValueLabel;
    private JTextField addToList;
    private JButton removeFromRightAtButton;
    private JButton addToRightAtFront;
    private JButton moveForwardButton;
    private JButton moveToBeginningButton;
    private JButton clearButton;
    private JButton countOfButton;
    private JButton undo;
    private JLabel lastRemoved;
    private JLabel leftLen;
    private JLabel rightLen;
    private JPanel myPanel;

    public JLabel getListValueLabel() {
        return listValueLabel;
    }

    public JTextField getAddToList() {
        return addToList;
    }

    public JButton getRemoveFromRightAtButton() {
        return removeFromRightAtButton;
    }

    public JButton getAddToRightAtFront() {
        return addToRightAtFront;
    }

    public JButton getMoveForwardButton() {
        return moveForwardButton;
    }

    public JButton getMoveToBeginningButton() {
        return moveToBeginningButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getCountOfButton() {
        return countOfButton;
    }

    public JButton getUndo() {
        return undo;
    }

    public JLabel getLastRemoved() {
        return lastRemoved;
    }

    public JLabel getLeftLen() {
        return leftLen;
    }

    public JLabel getRightLen() {
        return rightLen;
    }

    public JPanel getMyPanel() {
        return myPanel;
    }
}