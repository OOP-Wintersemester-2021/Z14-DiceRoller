package DiceRoller;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

import java.util.Random;

/**
 * This GraphicsApp displays a number of dice with randomly generated valued (1 to 6). Pressing any key will
 * automatically change the displayed values to a new, randomly generated, set of numbers.
 */

public class DiceRollerApp extends GraphicsApp {

    private static final int CANVAS_WIDTH = 950;
    private static final int CANVAS_HEIGHT = 200;
    private static final Color CANVAS_BACKGROUND = Colors.WHITE;
    // Number of dice to be displayed
    private static final int NUMBER_OF_DICE = 6;
    // Arry to hold all displayed dice
    private Die[] dice;

    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        dice = createDice();
        rollDice();
    }

    /**
     * Creates and returns an array of Dice with default values
     */
    private Die[] createDice() {
        Die[] dice = new Die[NUMBER_OF_DICE];
        int x = Die.DIE_SIZE / 2;
        int y = Die.DIE_SIZE / 2;
        for (int i = 0; i < NUMBER_OF_DICE; i++) {
            dice[i] = new Die(x, y);
            x += Die.DIE_SIZE * 1.5;
        }
        return dice;
    }

    @Override
    public void draw() {
        drawBackground(CANVAS_BACKGROUND);
        drawDice();
    }

    /**
     * Draws all dice in array
     */
    public void drawDice() {
        for (Die die : dice) {
            die.draw();
        }
    }

    /**
     * Foreshadowing next weeks topic, this method is called ONCE every time a key is pressed while the application is running
     */
    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        super.onKeyPressed(event);
        rollDice();
    }

    /**
     * Randomly rolls and sets new values for all dice
     */
    public void rollDice() {
        Random random = new Random();
        for (int i = 0; i < dice.length; i++) {
            int randomValue = 1 + random.nextInt(Die.MAX_VALUE);
            dice[i].setValue(randomValue);
        }
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
