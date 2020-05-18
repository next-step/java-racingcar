package racinggame.dto;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingGameInfo {
    private static final String RACING_CAR_DELIMITER = ",";

    private final List<String> carNames;
    private final int numberOfAttempt;

    public RacingGameInfo(final String carNames, final String numberOfAttempt) {
        this.carNames = parse(carNames);
        this.numberOfAttempt = toNumber(numberOfAttempt);
    }

    private List<String> parse(final String carNames) {
        String[] inputCars = carNames.split(RACING_CAR_DELIMITER);

        List<String> listOfCarNames = Arrays.stream(inputCars)
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .distinct()
                .collect(toList());

        if (inputCars.length != listOfCarNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 공백, 중복이 존재해서는 안됩니다");
        }

        return listOfCarNames;
    }

    private int toNumber(String numberOfAttempt) {
        try {
            int inputNumberOfAttempt = Integer.parseInt(numberOfAttempt);
            validate(Integer.parseInt(numberOfAttempt));
            return inputNumberOfAttempt;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("시도횟수는 숫자로 입력해야합니다. : " + numberOfAttempt);
        }
    }

    private void validate(int inputNumberOfAttempt) {
        if (inputNumberOfAttempt <= 0) {
            throw new IllegalArgumentException("시도횟수는 0보다 커야합니다");
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getNumberOfAttempt() {
        return numberOfAttempt;
    }
}
