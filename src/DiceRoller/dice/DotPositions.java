package DiceRoller.dice;

import DiceRoller.config.Config;
import de.ur.mi.oop.graphics.Point;


/**
 * Eine Schwierigkeit bei der Darstellung der Würfel ist das korrekte Platzieren der Augen. Um diese Aufgaben nicht
 * für jeden Würfel neu ausführen zu müssen, werden über diese Klasse die relativen Positionen der Augen einmalig
 * festgehalten. Die notwendigen Augen zur Darstellung bestimmter Würfelwerte können über eine Methode ausgelesen
 * werden. Im jeweiligen Würfel werden diese relativen Positionen dann mit der konkreten Position des Würfels selber
 * verrechnet, um die konkreten Augen für den jeweiligen Würfel anzuzeigen.
 * <p>
 * Zur Darstellung der Würfelwerte 1 bis 6 werden insgesamt sieben unterschiedliche Augenpositionen benötigt, die in
 * einer gedachten Matrix mit drei Spalten und drei Zeilen angeordnet sind. Diese Positionen werden von links nach
 * rechts und von oben nach unten nummeriert:
 * <p>
 * | 1 | - | 2 |
 * | 3 | 4 | 5 |
 * | 6 | - | 7 |
 * <p>
 * Für die Darstellung des Werts "1" wird ein Auge an der Position 4 benötigt, für die Darstellung des Werts "3" insgesamt
 * drei Augen an den Positionen 2, 4 und 6.
 */
public class DotPositions {

    // Relative x-Position des Auges an Position 1 (doppelter Radius als Abstand zwischen Mittelpunkt des Auges und Rand des Würfels)
    private static final int FIRST_X = Config.DOT_RADIUS * 2;
    // Relative Y-Position des Auges an Position 1
    private static final int FIRST_Y = Config.DOT_RADIUS * 2;
    // Konstanten für allen Positionen für die Augen 1 bis 7
    // Hinweis: Mit der Point-Klasse kann ein Koordinatenpaar (x und y) abgebildet werden
    private static final Point DOT_ONE = new Point(FIRST_X, FIRST_Y);
    private static final Point DOT_TWO = new Point(FIRST_X + Config.DOT_RADIUS * 6, FIRST_Y);
    private static final Point DOT_THREE = new Point(FIRST_X, FIRST_Y + Config.DOT_RADIUS * 3);
    private static final Point DOT_FOUR = new Point(FIRST_X + Config.DOT_RADIUS * 3, FIRST_Y + Config.DOT_RADIUS * 3);
    private static final Point DOT_FIVE = new Point(FIRST_X + Config.DOT_RADIUS * 6, FIRST_Y + Config.DOT_RADIUS * 3);
    private static final Point DOT_SIX = new Point(FIRST_X, FIRST_Y + Config.DOT_RADIUS * 6);
    private static final Point DOT_SEVEN = new Point(FIRST_X + Config.DOT_RADIUS * 6, FIRST_Y + Config.DOT_RADIUS * 6);

    private static final Point[] POSSIBLE_POSITIONS = {new Point(FIRST_X, FIRST_Y),
            new Point(FIRST_X + Config.DOT_RADIUS * 6, FIRST_Y),
            new Point(FIRST_X, FIRST_Y + Config.DOT_RADIUS * 3),
            new Point(FIRST_X + Config.DOT_RADIUS * 3, FIRST_Y + Config.DOT_RADIUS * 3),
            new Point(FIRST_X + Config.DOT_RADIUS * 6, FIRST_Y + Config.DOT_RADIUS * 3),
            new Point(FIRST_X, FIRST_Y + Config.DOT_RADIUS * 6),
            new Point(FIRST_X + Config.DOT_RADIUS * 6, FIRST_Y + Config.DOT_RADIUS * 6)};

    /**
     * Die Methode gibt die relativen Positionen der Augen zurück, die auf den Würfeln zur Darstellung des übergebenen Wertes
     * benötigt werden.
     *
     * @param value Würfelwert, der dargestellt werden soll.
     * @return Array mit Point-Werten, die die Positionen der benötigten Augen darstellen
     */
    public static Point[] getDotPositionsForValue(DieValue value) {
        /*
         * Hier wird eine verkürzte Form der switch-Anweisung verwendet, um auf Basis des übergebenen Parameters (Würfelwert)
         * ein Array mit den notwendigen Augenpositionen zurückzugeben. Das Array wird dabei beim Erstellen direkt mit den
         * notwendigen Werten aus den oben definierten Konstanten befüllt. In der Kurzschreibweise fällt auch der default-Case
         * weg.
         */
        return switch (value) {
            case ONE -> new Point[]{DOT_FOUR};
            case TWO -> new Point[]{DOT_TWO, DOT_SIX};
            case THREE -> new Point[]{DOT_TWO, DOT_FOUR, DOT_SIX};
            case FOUR -> new Point[]{DOT_ONE, DOT_TWO, DOT_SIX, DOT_SEVEN};
            case FIVE -> new Point[]{DOT_ONE, DOT_TWO, DOT_FOUR, DOT_SIX, DOT_SEVEN};
            case SIX -> new Point[]{DOT_ONE, DOT_TWO, DOT_THREE, DOT_FIVE, DOT_SIX, DOT_SEVEN};
        };
    }

}
