package racingCar.domain;

import racingCar.domain.car.RacingCar;
import racingCar.domain.car.RacingCars;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    public static List<RacingCar> findWinners(RacingCars racingCars) {
        int winnerPosition = getMaxPosition(racingCars);

        return racingCars.getRacingCarList().stream()
                .filter(racingCar -> racingCar.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }

    private static int getMaxPosition(RacingCars racingCars) {
        return racingCars.getRacingCarList().stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("경기를 시작하지 않았습니다."));
    }
}
