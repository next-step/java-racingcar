package step2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 0giri
 * @since : 2023/04/12
 */
public class Positives {

    private final List<Positive> positives;

    public Positives(List<Integer> numbers) {
        positives = numbers.stream()
            .map(Positive::new)
            .collect(Collectors.toList());
    }

    public List<Positive> values() {
        return positives;
    }

    public int sum() {
        return positives.stream()
            .mapToInt(Positive::value)
            .sum();
    }
}
