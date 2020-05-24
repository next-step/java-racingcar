package racingCar.domain;

import racingCar.domain.car.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    public static List<RacingCar> findWinners(List<RacingCar> racingCarList) {
        int winnerPosition = getMaxPosition(racingCarList);

        return racingCarList.stream()
                .filter(racingCar -> racingCar.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }

    private static int getMaxPosition(List<RacingCar> racingCarList) {
        return racingCarList.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("경기를 시작하지 않았습니다."));
    }
}
