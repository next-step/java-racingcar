package racinggame.dto;

import racinggame.exception.RacingGameInputException;

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

        if (isNotValidCarNames(inputCars, listOfCarNames)) {
            throw RacingGameInputException.ofCarNames();
        }

        return listOfCarNames;
    }

    private boolean isNotValidCarNames(String[] inputCars, List<String> listOfCarNames) {
        return inputCars.length != listOfCarNames.size();
    }

    private int toNumber(String numberOfAttempt) {
        try {
            int inputNumberOfAttempt = Integer.parseInt(numberOfAttempt);
            validate(Integer.parseInt(numberOfAttempt));
            return inputNumberOfAttempt;
        } catch (NumberFormatException numberFormatException) {
            throw RacingGameInputException.ofAttemptParsing(numberOfAttempt);
        }
    }

    private void validate(int inputNumberOfAttempt) {
        if (inputNumberOfAttempt <= 0) {
            throw RacingGameInputException.ofAttemptBound();
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getNumberOfAttempt() {
        return numberOfAttempt;
    }
}
