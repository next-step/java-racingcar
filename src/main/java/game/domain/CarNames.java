package game.domain;

import java.util.List;

public class CarNames {

    private static final String DELIMITER = ",";

    private final List<String> values;

    public CarNames(List<String> values) {
        this.values = values;
    }

    public static CarNames of(String input) {
        validateCarNames(input);
        return new CarNames(List.of(input.split(DELIMITER)));
    }

    private static void validateCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름 입력이 누락되었습니다.");
        }
    }

    public List<String> getNames() {
        return values;
    }

}