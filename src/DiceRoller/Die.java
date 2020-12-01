package DiceRoller;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.graphics.Point;
import de.ur.mi.oop.graphics.Rectangle;

/**
 * The class represents one single graphical die, which can display the values 1 to 6. Each die consist of a rectangular body
 * and one to six dots to display the actual value. A public method can be used to change the displayed value after creating
 * the die object. A public draw-Method will draw body and dots.
 */

public class Die {

    /**
     * public and private constants are used to configure parameters shared by each die.
     */
    public static final int DOT_RADIUS = DotPositions.DOT_RADIUS;
    public static final int DIE_SIZE = 100;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 6;
    private static final int DEFAULT_VALUE = 1;
    private static final Color BACKGROUND_COLOR = Colors.ORANGE;
    private static final Color DOT_COLOR = Colors.WHITE;

    // Rectangle to represent the die itself
    private Rectangle body;
    // Array of circles to represent each dot of the die (this array always contains those dot needed to represent the die's current value)
    private Circle[] dots;


    /**
     * Creates a new die at the given screen position using default values for size, color and current value
     */
    public Die(int x, int y) {
        body = new Rectangle(x, y, DIE_SIZE, DIE_SIZE, BACKGROUND_COLOR);
        setValue(DEFAULT_VALUE);
    }

    /**
     * Updates the circle array (dots) to let this die display the given value
     */
    public void setValue(int newValue) {
        // Early return to stop processing when new value is not within bounds
        if (newValue < MIN_VALUE || newValue > MAX_VALUE) {
            return;
        }
        dots = createDotsForValue(newValue);
    }

    /**
     * Creates a new set of circles to represent the dots needed to display the given value
     */
    private Circle[] createDotsForValue(int value) {
        // Load necessary positions for dots from DotPosition class
        int[] dotPositions = getDotPositionsForValue(value);
        // Create empty array for new circles
        Circle[] dots = new Circle[dotPositions.length];
        // Create all necessary dots and store them into array
        for (int i = 0; i < dotPositions.length; i++) {
            int dotPosition = dotPositions[i];
            // Get point (x/y coordinates) for dot on this position
            Point dotCenter = DotPositions.POSSIBLE_POSITIONS[dotPosition];
            // Use coordinates to create circle to represent dot
            dots[i] = new Circle(body.getXPos() + dotCenter.getXPos(), body.getYPos() + dotCenter.getYPos(), DOT_RADIUS, DOT_COLOR);
        }
        // Return filled array
        return dots;
    }

    /**
     * "Translates" the given die value into a set of dot positions
     */
    private int[] getDotPositionsForValue(int value) {
        // This switch-case is a shortcut for a more complete if-else construction to "switch" through all possible die values
        switch (value) {
            case 1:
                return DotPositions.DOTS_FOR_VALUE_ONE;
            case 2:
                return DotPositions.DOTS_FOR_VALUE_TWO;
            case 3:
                return DotPositions.DOTS_FOR_VALUE_THREE;
            case 4:
                return DotPositions.DOTS_FOR_VALUE_FOUR;
            case 5:
                return DotPositions.DOTS_FOR_VALUE_FIVE;
            case 6:
                return DotPositions.DOTS_FOR_VALUE_SIX;
            default:
                return null;
        }
    }

    /**
     * Draws the dice (body and currently needed dots)
     */
    public void draw() {
        body.draw();
        for (Circle dot : dots) {
            dot.draw();
        }
    }


}
