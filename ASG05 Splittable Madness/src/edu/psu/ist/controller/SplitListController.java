package edu.psu.ist.controller;

import edu.psu.ist.model.ISplittableList;
import edu.psu.ist.view.SplitListView;

import javax.swing.*;
import java.util.NoSuchElementException;
import java.util.Stack;

public class SplitListController {

    private ISplittableList<String> listModel;
    private SplitListView view;

    private Stack<ISplittableList<String>> undoStack;


    /**
     * Constructs a new SplitListController with the specified model and view.
     *
     * @param m The model implementing ISplittableList<String>.
     * @param v The view representing the SplitListView.
     */

    public SplitListController(ISplittableList<String> m, SplitListView v) {
        this.listModel = m;
        this.view = v;
        this.undoStack = new Stack<>();

        // Set the initial text rendering for the (empty) list
        view.getForm().getListValueLabel().setText(listModel.toString());

        // Add action listeners to the various buttons
        /**
         * Adds an action listener to the "Remove from Right" button, handling the button click event.
         * Removes an element from the right end of the list model and updates the view accordingly.
         */
        view.getForm().getRemoveFromRightAtButton().addActionListener(e -> {
            try {
                // Handle the remove from right button click event
                String removed = listModel.removeFromRightAtFront();
                view.getForm().getLastRemoved().setText("Last Removed: " + removed);
                view.getForm().getRightLen().setText("Right Length: " + listModel.rightLength());
                view.getForm().getLeftLen().setText("Left Length: " + listModel.leftLength());
                view.getForm().getListValueLabel().setText(listModel.toString());
            } catch (NoSuchElementException ex) {
                JOptionPane.showMessageDialog(view, "Right list is empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        /**
         * Adds an action listener to the "Add to Right at Front" button, handling the button click event.
         * This listener performs the following actions:
         * 1. Retrieves the element from the input field.
         * 2. Adds the element to the right end of the list model.
         * 3. Pushes a copy of the current state onto the undo stack for potential future undo operations.
         * 4. Clears the input field.
         * 5. Updates the view components with the modified state, including right length, count of the added element,
         *    and the overall string representation of the list.
         */

        view.getForm().getAddToRightAtFront().addActionListener(e -> {
            // Handle the add to right at front button click event
            String element = view.getForm().getAddToList().getText();
            listModel.addToRightAtFront(element);

            // Push a copy of the current state onto the undo stack
            undoStack.push(listModel.copyState());


            view.getForm().getAddToList().setText(""); // Clear the input field
            view.getForm().getRightLen().setText("Right Length: " + listModel.rightLength());
            view.getForm().getCountOfButton().setText("Count of " + element + ": " + listModel.countOf(element));
            view.getForm().getListValueLabel().setText(listModel.toString());
        });

        /**
         * Adds an action listener to the "Move Forward" button, handling the button click event.
         * This listener attempts to move an element from the right end to the left end of the list model.
         * If the right list is empty, an error message is displayed.
         * Upon successful move, it updates the view components with the modified state, including left and right lengths,
         * as well as the overall string representation of the list.
         */

        view.getForm().getMoveForwardButton().addActionListener(e -> {
            try {
                // Handle the move forward button click event
                listModel.moveForward();
                view.getForm().getLeftLen().setText("Left Length: " + listModel.leftLength());
                view.getForm().getRightLen().setText("Right Length: " + listModel.rightLength());
                view.getForm().getListValueLabel().setText(listModel.toString());
            } catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(view, "Right list is empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        /**
         * Adds an action listener to the "Move to Beginning" button, handling the button click event.
         * This listener moves all elements from the right end to the left end of the list model,
         * effectively placing them at the very beginning of the list.
         * It updates the view components with the modified state, including left and right lengths,
         * as well as the overall string representation of the list.
         */

        view.getForm().getMoveToBeginningButton().addActionListener(e -> {
            // Handle the move to beginning button click event
            listModel.moveToVeryBeginning();
            view.getForm().getLeftLen().setText("Left Length: " + listModel.leftLength());
            view.getForm().getRightLen().setText("Right Length: " + listModel.rightLength());
            view.getForm().getListValueLabel().setText(listModel.toString());
        });

        /**
         * Adds an action listener to the "Clear" button, handling the button click event.
         * This listener clears all elements from the list model, resetting both left and right sides to empty.
         * It updates the view components with the modified state, setting left and right lengths to 0,
         * and refreshing the overall string representation of the list.
         */

        view.getForm().getClearButton().addActionListener(e -> {
            // Handle the clear button click event
            listModel.clear();
            view.getForm().getLeftLen().setText("Left Length: 0");
            view.getForm().getRightLen().setText("Right Length: 0");
            view.getForm().getListValueLabel().setText(listModel.toString());
        });

        /**
         * Adds an action listener to the "Count of" button, handling the button click event.
         * This listener retrieves an element from the input field, counts its occurrences in the list model,
         * and displays a pop-up message with the count.
         * The input field is then cleared after processing.
         */

        view.getForm().getCountOfButton().addActionListener(e -> {
            // Handle the count of button click event
            String element = view.getForm().getAddToList().getText();
            int count = listModel.countOf(element);

            // Display a pop-up message with the count
            String message = "Number of times " + element + " occurs: " + count;
            JOptionPane.showMessageDialog(view, message, "Count", JOptionPane.INFORMATION_MESSAGE);

            // Clear the input field
            view.getForm().getAddToList().setText("");
        });

        /**
         * Adds an action listener to the "Undo" button, handling the button click event.
         * This listener checks if the undo stack is not empty, and if so, pops the previous state
         * from the undo stack. It then updates the list model and view components with the restored state.
         * Specifically, it sets the right and left lengths and updates the overall string representation of the list.
         */

        view.getForm().getUndo().addActionListener(e -> {
            if (!undoStack.isEmpty()) {
                // Pop the previous state from the undo stack
                listModel = undoStack.pop();

                // Update the view components with the restored state
                view.getForm().getRightLen().setText("Right Length: " + listModel.rightLength());
                view.getForm().getLeftLen().setText("Left Length: " + listModel.leftLength());
                view.getForm().getListValueLabel().setText(listModel.toString());
            }
        });
    }
}
