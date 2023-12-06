package edu.psu.ist.view;

import javax.swing.*;


public class PuzzleBoxView {
    private JLabel enterToAddLabel;
    private JTextField enterToAddText;
    private JLabel itemsInBoxLabel;
    private JLabel itemsInBoxNumLabel;
    private JButton addItemsButton;
    private JButton clearButton;
    private JButton sortButton;
    private JButton randomizeButton;
    private JButton doubleOrderButton;
    private JPanel puzzleBoxPanel;


    public PuzzleBoxView() {
        this.enterToAddLabel = enterToAddLabel;
        this.enterToAddText = enterToAddText;
        this.itemsInBoxLabel = itemsInBoxLabel;
        this.itemsInBoxNumLabel = itemsInBoxNumLabel;
        this.addItemsButton = addItemsButton;
        this.clearButton = clearButton;
        this.sortButton = sortButton;
        this.randomizeButton = randomizeButton;
        this.doubleOrderButton = doubleOrderButton;
        this.puzzleBoxPanel = puzzleBoxPanel;
    }



    public JTextField getEnterToAddText() {
        return enterToAddText;
    }

    public JButton getAddItemsButton() {
        return addItemsButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getSortButton() {
        return sortButton;
    }

    public JButton getRandomizeButton() {
        return randomizeButton;
    }

    public JButton getDoubleOrderButton() {
        return doubleOrderButton;
    }

    //public void updatePuzzleBoxLabel(String labelText) {
     //   itemsInBoxLabel.setText(labelText);
    //}

    public void updateItemCountLabel(String itemCount) {
        itemsInBoxNumLabel.setText(itemCount);
    }

    public JPanel getPuzzleBoxPanel() {
        return puzzleBoxPanel;
    }
}
