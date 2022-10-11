package racingcar.input;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CarNamesInput {

    private static final String SEPERATOR = ",";

    private List<String> carNames;

    private CarNamesInput() {
    }

    public CarNamesInput(final String carNames) {
        String[] splited = carNames.split(SEPERATOR);
        validateCarNames(splited);

        this.carNames = Arrays.asList(splited);
    }

    private void validateCarNames(final String[] input) {
        for (String name : input) {
            validateCarName(name);
        }
    }

    private void validateCarName(final String input) {
        if (Objects.isNull(input) || input.isEmpty() || input.length() > 5) {
            throw new RuntimeException("올바르지 않은 값입니다.");
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
