package racinggame.domain;

import java.util.stream.Collectors;

public class RacingGameResult {
    private final RacingCars racingCars;

    public RacingGameResult(final RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

    public RacingCars winners() {
        final int maxPosition = racingCars.getMaxPosition();

        return RacingCars.create(
            racingCars.stream()
                .filter(racingCar -> racingCar.currentPosition() == maxPosition)
                .collect(Collectors.toUnmodifiableList())
        );
    }
}
