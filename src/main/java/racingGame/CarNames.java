package racingGame;

import java.util.Arrays;
import java.util.List;

public class CarNames {

    private final List<String> names;

    private CarNames(List<String> names) {
        this.names = names;
    }

    public static CarNames from(String input) {
        List<String> parsed = Arrays.stream(input.split(","))
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .toList();
        return new CarNames(parsed);
    }

    public static CarNames from(List<String> names) {
        List<String> parsed = names.stream()
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .toList();
        return new CarNames(parsed);
    }

    public Cars toCars() {
        return Cars.fromNames(names);
    }
}
