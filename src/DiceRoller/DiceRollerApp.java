package DiceRoller;

import DiceRoller.config.Config;
import DiceRoller.dice.Die;
import DiceRoller.dice.DieValue;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

/**
 * Diese GraphicsApp stellt sechs Würfel dar, deren Wert (Anzahl der Augen) durch Tastendruck zufällig bestimmt
 * werden kann.
 */
public class DiceRollerApp extends GraphicsApp {

    // Label mit App-Namen und Hinweisen für die Nutzer*innen
    private Label appLabel;
    // Array mit den Würfeln
    private Die[] dice;

    @Override
    public void initialize() {
        setCanvasSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        appLabel = createAppLabel(); // Erstellt das Label mit den Anwendungsinformationen
        dice = createDice(); // Erstellt das Array mit den Würfeln
        rollDice(); // Würfelt die Werte aller Würfel neu (und zufällig) aus
    }

    /**
     * Die Methode erstellt ein Label am unteren, linken Rand der Zeichenfläche, in
     * der der Name der Anwendung und ein kurzer Hinweis zur Nutzung der Anwendung
     * angezeigt werden.
     *
     * @return Das erstellte Label
     */
    private Label createAppLabel() {
        Label label = new Label(0, 0, Config.APP_LABEL, Config.APP_LABEL_COLOR);
        label.setFont(Config.APP_LABEL_FONT);
        label.setFontSize(Config.APP_LABEL_FONT_SIZE);
        label.setXPos(label.getHeightEstimate());
        label.setYPos(getHeight() - label.getHeightEstimate());
        return label;
    }

    /**
     * Die Methode erstellt ein Array mit Würfeln, die horizontal nebeneinander auf
     * der Zeichenfläche angeordnet sind.
     *
     * @return Das Array mit den Würfeln
     */
    private Die[] createDice() {
        Die[] dice = new Die[Config.NUMBER_OF_DICE];
        // Position des ersten Würfels auf der X-Achse
        int x = Config.DIE_SIZE / 2;
        // Position des ersten Würfels auf der Y-Achse
        int y = Config.DIE_SIZE / 2;
        for (int i = 0; i < dice.length; i++) {
            // Wir erstellen einen neuen Würfel im Array ...
            dice[i] = new Die(x, y);
            // ... und bewegen die X-Position für den nächsten Würfel weiter nach rechts
            x += Config.DIE_SIZE * 1.5;
        }
        return dice;
    }

    /**
     * Setzt für alle Würfel im Array dice neue, zufällige Werte
     */
    private void rollDice() {
        for (Die die : dice) {
            die.setValue(DieValue.getRandomValue());
        }
    }

    @Override
    public void draw() {
        drawBackground(Config.BACKGROUND_COLOR);
        drawDice();
        appLabel.draw();
    }

    /**
     * Zeichnet alle Würfel im Array dice
     */
    public void drawDice() {
        for (Die die : dice) {
            die.draw();
        }
    }

    /**
     * Das ist ein Ausblick in die Zukunft. In zwei Wochen werden wir lernen, wie wir mit Eingaben
     * der Nutzer*innen in unseren GraphicsApp-Anwendungen umgehen. Mit dieser Methode fangen wir
     * z.B. alle Tastatureingaben ab, die erfolgen, während unsere Anwendung läuft und das
     * Anwendungsfenster fokussiert ist. In diesem einfachen Beispiel reagieren wir auf jede dieser
     * Eingaben mit dem erneuten Würfeln aller Würfel.
     */
    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        super.onKeyPressed(event);
        rollDice();
    }


    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
