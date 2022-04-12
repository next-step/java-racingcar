package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositiveNumbers {

    private List<PositiveNumber> positives;

    public PositiveNumbers(String[] splitTokens) {
        this.positives = new ArrayList<>();

        Arrays.stream(splitTokens)
            .forEach(s -> this.positives.add(new PositiveNumber(Integer.parseInt(s))));
    }

    public int sum() {
        return positives.stream()
            .mapToInt(PositiveNumber::getPositiveNumber)
            .sum();
    }
}
