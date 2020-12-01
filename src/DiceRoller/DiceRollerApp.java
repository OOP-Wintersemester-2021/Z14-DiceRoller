package DiceRoller;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

import java.util.Random;

public class DiceRollerApp extends GraphicsApp {

    private static final int CANVAS_WIDTH = 950;
    private static final int CANVAS_HEIGHT = 200;
    private static final Color CANVAS_BACKGROUND = Colors.WHITE;
    private static final int NUMBER_OF_DICE = 6;
    private Die[] dice;

    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        dice = createDice();
        rollDice();
    }

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

    public void drawDice() {
        for (Die die : dice) {
            die.draw();
        }
    }

    public void rollDice() {
        Random random = new Random();
        for(int i = 0; i < dice.length; i++) {
            int randomValue = 1 + random.nextInt(6);
            dice[i].setValue(randomValue);
        }
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        super.onKeyPressed(event);
        rollDice();
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
