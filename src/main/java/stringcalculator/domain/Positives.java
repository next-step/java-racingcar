package stringcalculator.domain;

import java.util.Arrays;

public class Positives {
    private Positive[] positives;

    public Positives(String[] stringNumbers) {
        this.positives = new Positive[stringNumbers.length];
        for (int i = 0; i < positives.length; i++) {
            positives[i] = new Positive(stringNumbers[i]);
        }
    }

    public int getSum() {
        return Arrays.stream(this.positives).mapToInt(Positive::parseInt).sum();
    }
}
