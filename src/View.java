import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    final JLabel tries;
    public View(Model model) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.tries = new JLabel("", SwingConstants.CENTER);
        this.tries.setFont(new Font("Colibri", Font.BOLD, 30));
        this.tries.setForeground(Color.WHITE);

        JPanel imagePanel = new JPanel();
        int columns = model.getColumns();
        imagePanel.setLayout(new GridLayout(columns, columns));
        for (JButton button : model.getButtons()) {
            imagePanel.add(button);
        }
        this.setTries(model.getTries());
        JPanel triesPanel = new JPanel();
        triesPanel.add(this.tries);
        triesPanel.setAlignmentX(CENTER_ALIGNMENT);
        triesPanel.setBackground(new Color(0x4661A6));
        this.add(triesPanel);
        this.add(imagePanel);
    }
    public void setTries(int triesLeft) {
        this.tries.setText("Tries left : " + triesLeft);
    }
}
