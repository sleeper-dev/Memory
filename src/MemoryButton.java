import javax.swing.*;
import java.awt.*;

public class MemoryButton extends JButton {
    static final String IMAGE_PATH = "";
    static final Image NO_IMAGE = Utilities.loadImage("no_image.png");
    public MemoryButton(String reference) {
        Image image = Utilities.loadImage(IMAGE_PATH + reference);
        Dimension dimension = new Dimension(128, 128);
        this.setPreferredSize(dimension);
        this.setIcon(new ImageIcon(NO_IMAGE));
        this.setDisabledIcon(new ReferencedIcon(image, reference));
    }
}
