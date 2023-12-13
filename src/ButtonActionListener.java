import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ButtonActionListener implements ActionListener {
    final Controller controller;
    final Model model;
    final View view;
    final JFrame window;
    static int disabledButtonCount = 0;
    static JButton lastDisabledButton = null;
    static final Image TRAP_IMAGE = Utilities.loadImage("no_image.png");
    final ReferencedIcon trap;
    public ButtonActionListener(Controller controller) {
        this.controller = controller;
        this.model = controller.getModel();
        this.view = controller.getView();
        this.window = controller.getWindow();
        this.trap = new ReferencedIcon(TRAP_IMAGE, "no_image.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button.setEnabled(false);
        ReferencedIcon thisIcon = (ReferencedIcon) button.getDisabledIcon();
        disabledButtonCount++;
        if (!model.isGameStarted()) {
            model.startGame();
        }
        if (disabledButtonCount == 2) {
            ReferencedIcon thatIcon = (ReferencedIcon) lastDisabledButton.getDisabledIcon();
            boolean isPair = thisIcon.getReference().equals(thatIcon.getReference());
            if (!isPair) {
                model.decrementTries();
                view.setTries(model.getTries());
                JButton lastButton = lastDisabledButton;
                Utilities.timer(500, ((ignored) -> {
                    button.setEnabled(true);
                    lastButton.setEnabled(true);
                }));
            }
            disabledButtonCount = 0;
        }
        ArrayList<JButton> enabledButtons = (ArrayList<JButton>) model.getButtons().stream().filter(Component::isEnabled).collect(Collectors.toList());
        if (enabledButtons.size() == 0) {
            controller.reset(new Model(controller.getModel().getColumns()));
            Dialogs.showWinDialog(window, model);
        }
        lastDisabledButton = button;
        if (model.getTries() == 0) {
            controller.reset(new Model(controller.getModel().getColumns()));
            Dialogs.showLoseDialog(window);
            Utilities.timer(1000, (ignored) -> model.getButtons().forEach(btn -> btn.setEnabled(false)));
        }
    }
}
