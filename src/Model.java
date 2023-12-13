import javax.swing.*;
import java.util.ArrayList;
import java.util.Vector;

public class Model {
    static final String[] AVAILABLE_IMAGES = new String[]{"0.png", "1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png"};
    static final Integer MAX_REGISTERED_SCORES = 10;
    final ArrayList<Float> scores;
    final ArrayList<JButton> buttons;
    final int columns;
    int tries;
    boolean gameStarted;
    public Model(int columns) {
        this.columns = columns;
        this.buttons = new ArrayList<>();
        this.scores = new ArrayList<>();
        this.tries =  10;
        this.gameStarted = false;
        int numberOfImage = columns * columns;
        Vector<Integer> v = new Vector<>();
        for (int i = 0; i < numberOfImage - numberOfImage % 2; i++) {
            v.add(i % (numberOfImage / 2));
        }
        if (numberOfImage % 2 != 0) v.add(AVAILABLE_IMAGES.length - 1);

        for (int i = 0; i < numberOfImage; i++) {
            int rand = (int) (Math.random() * v.size());
            String reference = AVAILABLE_IMAGES[v.elementAt(rand)];
            this.buttons.add(new MemoryButton(reference));
            v.removeElementAt(rand);
        }
    }
    public int getColumns() {
        return columns;
    }
    public ArrayList<JButton> getButtons() {
        return buttons;
    }

    public int getTries() {
        return tries;
    }

    public void decrementTries() {
        this.tries--;
    }

    public boolean isGameStarted() {
        return this.gameStarted;
    }

    public void startGame() {
        this.gameStarted = true;
    }
}
