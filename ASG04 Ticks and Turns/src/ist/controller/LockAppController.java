package ist.controller;

import edu.psu.ist.model.IDialLock;
import edu.psu.ist.view.LockAppView;

import javax.swing.*;

public class LockAppController {

    private LockAppView view;
    private IDialLock model;

    public LockAppController(LockAppView lockView, IDialLock lockModel) {
        this.view = lockView;
        this.model = lockModel;

        view.form().getLockStatusViewLabel().setText("Locked! " + model.toString());

        view.form().getCurrentTickValueLabel().setText(model.currentTick() + "");

        // TODO: Attach lambda expressions to each button

        view.form().getRightButton().addActionListener(e -> {
            model.right(1); // Update the lock model by turning right by 1
            view.form().getCurrentTickValueLabel().setText(String.valueOf(model.currentTick())); // Update the current tick label
        });


        view.form().getLeftButton().addActionListener(e -> {
            // Update the lock model by turning left by 1
            model.left(1);

            // Update the current tick label
            view.form().getCurrentTickValueLabel().setText(String.valueOf(model.currentTick()));

        });

        view.form().getPullButton().addActionListener(e -> {
            if (model.pull()) {
                // Lock successfully opened
                JOptionPane.showMessageDialog(view, "Lock opened successfully!");
                view.form().getLockStatusViewLabel().setText("UNLOCKED! " + model.toString());
                view.form().getCurrentTickValueLabel().setText(String.valueOf(model.currentTick()));
            } else {
                // Lock failed to open
                JOptionPane.showMessageDialog(view, "Combination wrong...");
                // You may want to reset the current tick display in case of a failed attempt
                view.form().getCurrentTickValueLabel().setText("0");
            }
        });

        view.form().getResetButton().addActionListener(e -> {
            // Reset the lock model
            model.reset();

            // Update the current tick label and lock status label
            view.form().getCurrentTickValueLabel().setText("0");
            view.form().getLockStatusViewLabel().setText("Locked! " + model.toString());

        });
    }
}
