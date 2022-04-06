package step2;

import java.util.ArrayList;
import java.util.List;

public class PositiveNumbers {

    private List<Positive> positives;

    public PositiveNumbers(String[] splitTokens) {
        this.positives = new ArrayList<>();

        for (String splitToken : splitTokens) {
            this.positives.add(new Positive(Integer.parseInt(splitToken)));
        }
    }

    public int sum() {
        return positives.stream()
            .mapToInt(Positive::getPositiveNumber)
            .sum();
    }
}
