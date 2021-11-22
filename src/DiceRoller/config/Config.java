package DiceRoller.config;

import de.ur.mi.oop.colors.Color;

/**
 * In dieser Klasse werden alle wichtige Parameter der Anwendung an einem zentralen Ort gesammelt
 * und dokumentiert. (Fast) alle Werten sind als öffentliche Konstante angelegt und können von
 * anderen Stellen der Anwendung über den Klassennamen und den entsprechenden Bezeichner der
 * Konstante ausgelesen werden, z.B.: "Config.WINDOW_WIDTH". Mit diesem Ansatz werden zwei Ziele
 * verfolgt. 1) Alle wichtigen Werte können von allen anderen Stellen im Code ausgelesen werden,
 * ohne dass diese mehrfach in den verschiedenen Klassen angelegt werden müssen und 2) Sollten
 * Änderungen an bestimmten Werten nötig oder gewünscht sein, z.B. bezüglich der Darstellung der
 * Würfel, können diese zentral angepasst werden, ohne dass der Code der übrigen Anwendung
 * verändert werden muss: Nur in dieser Klasse stehen tatsächliche Werte, alle anderen Stellen im Code
 * verweisen auf diese Klasse.
 */

public class Config {

    /* "Selbstgemischte" Farben für verschiedene Teile der Anwendung */
    private static final Color YELLOW = new Color(234, 182, 56);
    private static final Color GREY = new Color(47, 61, 76);

    /* Fenstergröße und Farben */
    public static final int WINDOW_WIDTH = 950;
    public static final int WINDOW_HEIGHT = 225;
    public static final Color BACKGROUND_COLOR = GREY;
    public static final Color DIE_BACKGROUND_COLOR = YELLOW;
    public static final Color DIE_DOT_COLOR = GREY; // Farbe für einzelne Augen der Würfel

    /* Parameter für Würfel */
    public static final int NUMBER_OF_DICE = 6; // Anzahl der darzustellenden Würfel
    public static final int DIE_SIZE = 100; // Breite und Höhe der Würfel
    public static final int DOT_RADIUS = 10; // Radius der einzelnen Augen im Würfel

    /* Parameter für App-Label */
    public static final String APP_LABEL = "Dice Roller (press any key to roll)";
    public static final String APP_LABEL_FONT = "Bahnschrift";
    public static final Color APP_LABEL_COLOR = YELLOW;
    public static final int APP_LABEL_FONT_SIZE = 20;
}
