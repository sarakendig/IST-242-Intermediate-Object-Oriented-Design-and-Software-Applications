package edu.psu.ist.view;

import javax.swing.*;

public class SplitListView extends JFrame {
    private final SplitListForm form;

    public SplitListView() {
        this.form = new SplitListForm();
        JPanel content = form.getMyPanel();
        this.setContentPane(content);
        this.pack();

        this.setTitle("Splittable Madness"); // change if you like
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public SplitListForm getForm() {
        return form;
    }
}
