package DiceRoller;

import de.ur.mi.oop.graphics.Point;

/**
 * This class contains information necessary to draw all possible dice. The array POSSIBLE_POSITIONS contains
 * all seven possible positions for the dices' dots. The arrays DOTS_FOR_VALUE_ONE to DOTS_FOR_VALUE_SIX reference
 * those positions, needed to draw certain dice values. All positions are relative to a given die radius.
 */

public class DotPositions {

    public static final int DOT_RADIUS = 10;
    private static final int FIRST_X = DOT_RADIUS * 2;
    private static final int FIRST_Y = DOT_RADIUS * 2;
    public static final Point[] POSSIBLE_POSITIONS = {new Point(FIRST_X, FIRST_Y),
            new Point(FIRST_X + DOT_RADIUS * 6, FIRST_Y),
            new Point(FIRST_X, FIRST_Y + DOT_RADIUS * 3),
            new Point(FIRST_X + DOT_RADIUS * 3, FIRST_Y + DOT_RADIUS * 3),
            new Point(FIRST_X + DOT_RADIUS * 6, FIRST_Y + DOT_RADIUS * 3),
            new Point(FIRST_X, FIRST_Y + DOT_RADIUS * 6),
            new Point(FIRST_X + DOT_RADIUS * 6, FIRST_Y + DOT_RADIUS * 6)};
    public static final int[] DOTS_FOR_VALUE_ONE = {3};
    public static final int[] DOTS_FOR_VALUE_TWO = {1, 5};
    public static final int[] DOTS_FOR_VALUE_THREE = {1, 3, 5};
    public static final int[] DOTS_FOR_VALUE_FOUR = {0, 1, 5, 6};
    public static final int[] DOTS_FOR_VALUE_FIVE = {0, 1, 3, 5, 6};
    public static final int[] DOTS_FOR_VALUE_SIX = {0, 1, 2, 4, 5, 6};

}
