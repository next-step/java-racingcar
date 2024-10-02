package racing.input;

import racing.exception.InvalidInputValueException;

import java.util.Arrays;
import java.util.List;

public class RaceLineUp {

    private final static String INPUT_DELIMITER = ",";

    private final List<String> names;

    private RaceLineUp(String input) {
        validateInput(input);

        List<String> splitNames = List.of(input.split(INPUT_DELIMITER));
        validateNames(splitNames);

        this.names = splitNames;
    }

    public static RaceLineUp of(String input) {
        return new RaceLineUp(input);
    }

    private void validateInput(String input) {
        if (input.isBlank()) {
            throw new InvalidInputValueException("레이스 참가자 수는 1 이상이여야 합니다.");
        }
    }

    private void validateNames(List<String> splitNames) {
        if (splitNames.stream().anyMatch(splitName -> splitName.length() > 5)) {
            throw new InvalidInputValueException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public List<String> names() {
        return names;
    }

    public int count() {
        return names.size();
    }
}
