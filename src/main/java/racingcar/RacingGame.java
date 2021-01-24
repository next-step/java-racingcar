package racingcar;

import java.util.List;

import static racingcar.ExceptionMessages.*;

public class RacingGame {
    private final Cars cars;
    private final int rounds;

    public RacingGame(List<String> carNames, int rounds) {
        validateSize(carNames);
        validateNonBlankNames(carNames);
        validateRounds(rounds);
        this.cars = new Cars(carNames);
        this.rounds = rounds;
    }

    private void validateSize(final List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAMES_ARE_EMPTY);
        }
    }

    private void validateNonBlankNames(final List<String> carNames) {
        for (String carName : carNames) {
            throwExceptionIfCarNameIsNullOrBlank(carName);
        }
    }

    private void throwExceptionIfCarNameIsNullOrBlank(final String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException(NO_NAME_CAR_EXISTS);
        }
    }

    private void validateRounds(final int rounds) {
        if (rounds < 1) {
            throw new IllegalArgumentException(ROUNDS_MUST_BE_AT_LEAST_ONE);
        }
    }

    public void play() {
        for (int i = 0; i < rounds; i++) {
            cars.moveAll(new MovementCondition());
        }
        cars.selectWinners();
    }
}
