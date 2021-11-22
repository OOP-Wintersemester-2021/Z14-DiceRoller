package DiceRoller.dice;

import DiceRoller.config.Config;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.graphics.Point;
import de.ur.mi.oop.graphics.Rectangle;

/**
 * Diese Klasse repräsentiert einen einzelnen, sichtbaren Würfel innerhalb der Anwendung. Ein Würfel wird durch ein gelbes
 * Rechteck repräsentiert, auf dem zu jedem Zeitpunkt genau die Augen als Kreise dargestellt werden, die zur Anzeige des
 * aktuellen Würfelwerts benötigt werden. Der Würfelwert kann über eine öffentliche Methode verändert werden. Die erlaubten
 * Werte werden dabei durch das Enum DieValue vorgegeben. Eine weitere öffentliche Methoden dient dem Zeichnen vom Würfel
 * und dessen Augen.
 */
public class Die {

    // Das Rechteck zur Darstellung des Würfels
    private final Rectangle body;
    // Alle Augen zur Darstellung des aktuellen Werts des Würfels
    private Circle[] dots;

    /**
     * Erzeugt einen neuen Würfel an den angegebenen Koordinaten der Zeichenfläche.
     *
     * @param x Obere, linke Ecke des Würfels auf der X-Achse
     * @param y Obere, linke Ecke des Würfels auf der Y-Achse
     */
    public Die(int x, int y) {
        body = new Rectangle(x, y, Config.DIE_SIZE, Config.DIE_SIZE, Config.DIE_BACKGROUND_COLOR);
        setValue(DieValue.ONE);
    }

    /**
     * Ändert den aktuellen Wert des Würfels.
     *
     * @param value Der neue Wert des Würfels
     */
    public void setValue(DieValue value) {
        // Wenn der Wert des Würfels geändert wird, wird ein neues Set an Augen erstellt und gespeichert
        dots = createDotsForValue(value);
    }

    /**
     * Erzeugt ein Array mit Kreisen zur Darstellung des übergebenen Wertes für diesen Würfel. Die relativen
     * Positionen der benötigten Augen werden über eine öffentliche, statische Methode der Klasse DotPosition
     * ausgelesen. Diese Positionen werden mit der aktuellen Position des Würfels verrechnet, um die benötigten
     * Circle-Instanzen für die Augen zu erstellen.
     *
     * @param value Der Wert, der im Würfel angezeigt werden soll
     * @return Ein Array mit Circle-Objekten, die die benötigten Augen repräsentieren
     */
    private Circle[] createDotsForValue(DieValue value) {
        // Auslesen der benötigten, relativen Positionen der Würfelaugen
        Point[] dotPositions = DotPositions.getDotPositionsForValue(value);
        // Erstellen des leeren Arrays für die Kreise zur Darstellung der Würfelaugen
        Circle[] dots = new Circle[dotPositions.length];
        // Schleife über das noch leere Array zum Erstellen der Kreise
        for (int i = 0; i < dotPositions.length; i++) {
            // Auslesen der relativen Position des Auges
            Point dotCenter = dotPositions[i];
            // Erstellen des Kreises zur Repräsentation des Auges
            dots[i] = new Circle(body.getXPos() + dotCenter.getXPos(), body.getYPos() + dotCenter.getYPos(), Config.DOT_RADIUS, Config.DIE_DOT_COLOR);
        }
        return dots;
    }

    /**
     * Die Methode zeichnet zuerst den Würfel und dann alle Augen.
     */
    public void draw() {
        body.draw();
        for (Circle dot : dots) {
            dot.draw();
        }
    }


}
