package edu.psu.ist;

import edu.psu.ist.controller.Controller;
import edu.psu.ist.model.PuzzleBox;
import edu.psu.ist.view.PuzzleBoxView;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        // Create instances of the model, view, and controller
        PuzzleBox<String> puzzleBox = new PuzzleBox<>();
        PuzzleBoxView puzzleBoxView = new PuzzleBoxView();
        Controller controller = new Controller(puzzleBox, puzzleBoxView);

        // Set up the main frame
        JFrame frame = new JFrame("Puzzle Box App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Set the content pane
        frame.setContentPane(puzzleBoxView.getPuzzleBoxPanel());

        // Update button states
        controller.updateButtonStates();

        // Make the frame visible
        frame.setVisible(true);
    }
}


