import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class Utilities {
    static final ClassLoader cl = Utilities.class.getClassLoader();

    public static void timer(int delay, ActionListener listener) {
        Timer t = new Timer(delay, listener);
        t.setRepeats(false);
        t.start();
    }

    public static Image loadImage(String s) {
        Image image = null;
        try {
            InputStream resourceStream = cl.getResourceAsStream(s);
            if (resourceStream != null) {
                ImageInputStream imageStream = ImageIO.createImageInputStream(resourceStream);
                image = ImageIO.read(imageStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
