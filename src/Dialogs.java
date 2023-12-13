import javax.swing.*;
import java.awt.*;

public class Dialogs {
    public static void showLoseDialog(JFrame window) {
        UIManager.put("OptionPane.background", new Color(0x99BDEA));
        UIManager.put("Panel.background", new Color(0x99BDEA));
        JOptionPane.showMessageDialog(window, "You lost, try again !", "You lost !", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void showWinDialog(JFrame window, Model model) {
        String message = String.format("Congrats you won!!");
        UIManager.put("OptionPane.background", new Color(0x99BDEA));
        UIManager.put("Panel.background", new Color(0x99BDEA));
        JOptionPane.showMessageDialog(window.getContentPane(), message, "", JOptionPane.INFORMATION_MESSAGE);
    }
}
