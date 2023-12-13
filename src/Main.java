import javax.swing.*;
import java.util.Locale;

public class Main {
    static final int DEFAULT_SIZE = 4;
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        SwingUtilities.invokeLater(() -> new Controller(new Model(DEFAULT_SIZE)));
    }
}