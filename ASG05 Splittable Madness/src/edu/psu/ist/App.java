package edu.psu.ist;

import edu.psu.ist.controller.SplitListController;
import edu.psu.ist.model.ISplittableList;
import edu.psu.ist.model.UtilListImpl;
import edu.psu.ist.view.SplitListView;

public class App {

    public static void main(String[] args) {
        // Create the model
        ISplittableList<String> model = new UtilListImpl<>();

        // Create the view
        SplitListView view = new SplitListView();

        // Create the controller and connect it to the model and view
        SplitListController controller = new SplitListController(model, view);

        // Set the view to be visible
        view.setVisible(true);
    }
}