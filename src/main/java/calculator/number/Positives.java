package calculator.number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Positives {

    private final List<Positive> positives;

    public Positives(String[] strings) {
        this(convertToPositives(strings));
    }

    public Positives(List<Positive> positives) {
        this.positives = positives;
    }

    private static List<Positive> convertToPositives(String[] strings) {
        return Arrays.stream(strings)
                .map(Positive::new)
                .collect(Collectors.toList());
    }

    public int addAll() {
        if (positives.isEmpty()) {
            return 0;
        }

        return this.positives.stream()
                .skip(1)
                .reduce(positives.get(0), Positive::add)
                .value();
    }

}
