package DiceRoller.dice;

/**
 * Mit diesem Enum werden alle erlaubten Werte der Würfel (Anzahl der Augen)
 * festgehalten. An allen Stellen der Anwendung, an der diese Information wichtig
 * ist, wird ein Wert aus diesem Enum verwendet. Wir stellen damit sicher, dass
 * innerhalb der Anwendung nur diese sechs möglichen Werte für die Anzahl der
 * Würfelaugen verwendet werden können und verhindern damit mögliche Fehlersituationen,
 * die durch inkompatible Werte erzeugt werden könnten.
 */
public enum DieValue {
    ONE, // 1 = ein Auge
    TWO, // 2 = zwei Augen
    THREE, // 3 = drei Augen
    FOUR, // 4 = vier Augen
    FIVE, // 5 = fünf Augen
    SIX; // 6 = sechs Augen

    /**
     * Enums können (statische) Methoden beinhalten. Mit dieser Methode wird ein
     * zufällig ausgewählter Wert aus dem Enum zurückgegeben.
     *
     * @return Ein zufällig ausgewählter Wert aus dem Enum
     */
    public static DieValue getRandomValue() {
        /*
         * Aus jedem Enum kann über die Methode values ein Array mit allen
         * Werten ausgelesen werden, die im Enum definiert sind.
         */
        DieValue[] availableValues = DieValue.values();
        // Wir berechnen einen zufälligen Index im Wertebereich des Arrays ...
        int randomOrdinal = (int) (Math.random() * availableValues.length);
        // ... und nutzen diesen um einen der Werte auszuwählen und zurückzugeben
        return availableValues[randomOrdinal];
    }
}
