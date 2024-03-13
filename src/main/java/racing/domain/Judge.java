package racing.domain;

import racing.domain.RacingCar;
import racing.domain.RacingCars;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Judge {
    public static List<String> selectWinners(RacingCars racingCars) {
        int highScore = getMaxPosition(racingCars);

        return racingCars.getRacingCarList()
                .stream()
                .filter(car -> isWinner(car, highScore))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private static boolean isWinner(RacingCar racingCar, int highScore) {
        return racingCar.getPosition() == highScore;
    }

    private static int getMaxPosition(RacingCars racingCars) {
        return Collections.max(
                racingCars.getRacingCarList()
                        .stream()
                        .map(RacingCar::getPosition)
                        .collect(Collectors.toList()));
    }
}
