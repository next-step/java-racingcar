package racingcar.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RacingInput {

    private static final String SEPERATOR = ",";

    private List<String> carNames;
    private int tryNumber;

    private RacingInput() {
    }

    public RacingInput(final String carNames, final int tryNumber) {
        String[] splited = carNames.split(SEPERATOR);
        validateCarNames(splited);
        validateTryNumber(tryNumber);

        this.carNames = Arrays.asList(splited);
        this.tryNumber = tryNumber;
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

    private void validateTryNumber(final int input) {
        if (input < 0) {
            throw new RuntimeException("올바르지 않은 값입니다.");
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
