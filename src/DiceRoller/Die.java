package DiceRoller;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.graphics.Point;
import de.ur.mi.oop.graphics.Rectangle;

public class Die {

    public static final int DOT_RADIUS = 10;
    public static final int DIE_SIZE = 100;
    private static final int DEFAULT_VALUE = 5;
    private static final Color BACKGROUND_COLOR = Colors.ORANGE;
    private static final Color DOT_COLOR = Colors.WHITE;

    private Rectangle body;
    private Circle[] dots;


    public Die(int x, int y) {
        body = new Rectangle(x, y, DIE_SIZE, DIE_SIZE, BACKGROUND_COLOR);
        setValue(DEFAULT_VALUE);
    }

    public void setValue(int newValue) {
        dots = createDotsForValue(newValue);
    }

    private Circle[] createDotsForValue(int value) {
        int[] dotPositions = getDotPositionsForValue(value);
        Circle[] dots = new Circle[dotPositions.length];
        for (int i = 0; i < dotPositions.length; i++) {
            int dotPosition = dotPositions[i];
            Point dotCenter = DotPositions.POSSIBLE_POSITIONS[dotPosition];
            dots[i] = new Circle(body.getXPos() + dotCenter.getXPos(), body.getYPos() + dotCenter.getYPos(), DOT_RADIUS, DOT_COLOR);
        }
        return dots;
    }

    private int[] getDotPositionsForValue(int value) {
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

    public void draw() {
        body.draw();
        for (Circle dot : dots) {
            dot.draw();
        }
    }


}
