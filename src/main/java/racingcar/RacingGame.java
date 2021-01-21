package racingcar;

import java.util.List;

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
            throw new IllegalArgumentException("자동차 이름이 비어 있습니다.");
        }
    }

    private void validateNonBlankNames(final List<String> carNames) {
        for (String carName : carNames) {
            if (carName == null || carName.isBlank()) {
                throw new IllegalArgumentException("이름이 없는 자동차가 있습니다.");
            }
        }
    }

    private void validateRounds(final int rounds) {
        if (rounds < 1) {
            throw new IllegalArgumentException("라운드는 최소 1 이상이어야 합니다.");
        }
    }

    public void play() {
        for (int i = 0; i < rounds; i++) {
            cars.moveAll(new MovementCondition());
        }
        cars.printWinners();
    }
}
