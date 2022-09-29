package racingcar.domain;

import java.util.stream.Collectors;

public class RacingCarWinnerSelector {

    private RacingCarWinnerSelector() {
    }

    public static RacingCars selectWinners(RacingCars racingCars) {
        int maxPosition = getMaxPosition(racingCars);
        return new RacingCars(
            racingCars.getValue().stream()
                .filter(racingCar -> racingCar.isEqualsPosition(maxPosition))
                .collect(Collectors.toList())
        );
    }

    private static int getMaxPosition(RacingCars racingCars) {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars.getValue()) {
            int position = racingCar.getPosition();
            maxPosition = Math.max(maxPosition, position);
        }

        return maxPosition;
    }
}
