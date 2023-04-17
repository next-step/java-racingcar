package game.domain;

import java.util.List;

public class CarNames {

    private static final String DELIMITER = ",";

    private final List<String> values;

    public CarNames(List<String> values) {
        this.values = values;
    }

    public static CarNames of(String input) {
        return new CarNames(List.of(input.split(DELIMITER)));
    }

    public List<String> getNames() {
        return values;
    }

}