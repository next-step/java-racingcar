package racingCar.domain;

import racingCar.domain.car.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    private final List<RacingCar> racingCarList;

    public RacingGameResult(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public List<RacingCar> findWinners() {
        int winnerPosition = getMaxPosition();

        return racingCarList.stream()
                .filter(racingCar -> racingCar.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return racingCarList.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("경기를 시작하지 않았습니다."));
    }
}
