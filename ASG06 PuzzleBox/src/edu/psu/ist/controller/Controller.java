package edu.psu.ist.controller;

import edu.psu.ist.model.IProducer;
import edu.psu.ist.model.PuzzleBox;
import edu.psu.ist.view.PuzzleBoxView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Controller class serves as the controller in the MVC architecture for the Puzzle Box application.
 * It handles user input and updates the model and view accordingly.
 */
public class Controller {

    private PuzzleBox<String> puzzleBox;
    private PuzzleBoxView view;

    /**
     * Constructs a new Controller with the specified PuzzleBox and PuzzleBoxView.
     *
     * @param puzzleBox The PuzzleBox model.
     * @param view      The PuzzleBoxView.
     */
    public Controller(PuzzleBox<String> puzzleBox, PuzzleBoxView view) {
        this.puzzleBox = puzzleBox;
        this.view = view;

        // Add action listeners to buttons
        view.getAddItemsButton().addActionListener(e -> onAddItemsButtonClicked());
        view.getClearButton().addActionListener(e -> onClearButtonClicked());
        view.getSortButton().addActionListener(e -> onSortButtonClicked());
        view.getDoubleOrderButton().addActionListener(e -> onDoubleOrderButtonClicked());
        view.getRandomizeButton().addActionListener(e -> onRandomizeButtonClicked());
    }

    /**
     * Handles the event when the "Add Items" button is clicked.
     * Clears the puzzle box, adds items from the input, and updates the GUI elements.
     */
    public void onAddItemsButtonClicked() {
        // Clear the box before adding new items
        puzzleBox.clear();

        String inputText = view.getEnterToAddText().getText().trim();
        if (inputText.isEmpty()) {
            JOptionPane.showMessageDialog(view.getPuzzleBoxPanel(), "Invalid input: Enter items to add.");
            return;
        }

        List<String> itemsToAdd = getTextFieldContents(inputText);
        puzzleBox.addItemsTo(itemsToAdd);

        // Update GUI elements
        view.updateItemCountLabel(String.valueOf(puzzleBox.numOfItems()));

        // Enable/Disable buttons based on logic
        updateButtonStates();
    }

    /**
     * Handles the event when the "Clear" button is clicked.
     * Clears the puzzle box and updates the GUI elements.
     */
    public void onClearButtonClicked() {
        puzzleBox.clear();

        // Update GUI elements
        view.updateItemCountLabel(String.valueOf(puzzleBox.numOfItems()));

        // Enable/Disable buttons based on logic
        updateButtonStates();
    }

    /**
     * Handles the event when the "Sort" button is clicked.
     * Sorts the items in the puzzle box and updates the GUI elements.
     */
    public void onSortButtonClicked() {
        puzzleBox.sort();

        // Enable/Disable buttons based on logic
        updateButtonStates();
    }

    /**
     * Handles the event when the "Double Order" button is clicked.
     * Displays a dialog box with information about whether the puzzle box is in double order.
     */
    public void onDoubleOrderButtonClicked() {
        boolean isDoubleOrder = puzzleBox.inDoubleOrder();

        // Display result in a dialog box
        JOptionPane.showMessageDialog(view.getPuzzleBoxPanel(), "Is in double order: " + isDoubleOrder);
    }

    /**
     * Handles the event when the "Randomize" button is clicked.
     * Randomly populates the puzzle box and updates the GUI elements.
     */
    public void onRandomizeButtonClicked() {
        IProducer<String> randomProducer = () -> String.valueOf((int) (Math.random() * 6));
        puzzleBox.randomlyPopulate(randomProducer);

        // Update GUI elements
        view.updateItemCountLabel(String.valueOf(puzzleBox.numOfItems()));

        // Enable/Disable buttons based on logic
        updateButtonStates();
    }

    /**
     * Updates the enabled states of buttons based on the current state of the puzzle box.
     */
    public void updateButtonStates() {
        // Enable the clear button if there are items in the puzzle box
        view.getClearButton().setEnabled(puzzleBox.numOfItems() > 0);

        // Enable the sort button if there are items in the puzzle box
        view.getSortButton().setEnabled(puzzleBox.numOfItems() > 0);

        // Enable the double order button if there are items in the puzzle box
        view.getDoubleOrderButton().setEnabled(puzzleBox.numOfItems() > 0);

        // Enable the randomize button
        view.getRandomizeButton().setEnabled(true);
    }

    /**
     * Parses the contents of a text field and returns a list of strings.
     *
     * @param textFieldStr The string content of the text field.
     * @return A list of strings parsed from the input.
     */
    public List<String> getTextFieldContents(String textFieldStr) {
        List<String> result = new ArrayList<>();

        for (String s : textFieldStr.split("\\s+")) {
            s = s.trim();
            if (s.isEmpty() || s.isBlank() || s.contains(" ")) {
                JOptionPane.showMessageDialog(view.getPuzzleBoxPanel(),
                        "Invalid pattern: must be a " +
                                "whitespace delimited list");
                return new ArrayList<>();
            }
            result.add(s);
        }
        return result;
    }
}
