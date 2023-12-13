import javax.swing.*;

public class Controller {
    final JFrame window;
    Model model;
    View view;

    public Controller(Model model) {
        this.window = new JFrame("Memory");
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.window.setResizable(false);
        this.reset(model);
    }

    public void reset(Model model) {
        this.model = model;
        this.view = new View(model);
        this.window.setVisible(false);
        this.window.setContentPane(view);
        this.window.pack();
        this.window.setLocationRelativeTo(null);
        for (JButton button : this.model.getButtons()) {
            button.addActionListener(new ButtonActionListener(this));
        }
        Utilities.timer(200, (ignored) -> this.window.setVisible(true));
    }
    public JFrame getWindow() {
        return this.window;
    }
    public Model getModel() {
        return this.model;
    }
    public View getView() {
        return this.view;
    }
}
