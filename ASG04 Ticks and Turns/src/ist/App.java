package ist;

import edu.psu.ist.controller.LockAppController;
import edu.psu.ist.model.IDialLock;
import edu.psu.ist.model.TrLockImpl;
import edu.psu.ist.view.LockAppView;

public class App {

    public static void main(String[] args) {
        IDialLock model = new TrLockImpl(1, 2, 5, 9); // plug in secret digits here
        LockAppView view = new LockAppView();

        LockAppController controller = new LockAppController(view, model);
        view.setVisible(true);
    }
}
