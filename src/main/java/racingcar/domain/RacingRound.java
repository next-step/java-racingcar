package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingRound {
    private static final String RACING_CAR_EMPTY_MESSAGE = "참가한 자동차 리스트가 비었습니다.";
    private List<RacingCar> racingCars;

    public RacingRound(List<RacingCar> cars) {
        this.racingCars = cars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<String> getWinners() {
        final RacingCar maxPositionCar = findMaxPositionCar();
        return findSamePositionCars(maxPositionCar);
    }

    private RacingCar findMaxPositionCar() {
        return racingCars.stream()
                .max(RacingCar::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(RACING_CAR_EMPTY_MESSAGE));
    }

    private List<String> findSamePositionCars(RacingCar maxPositionCar) {
        return racingCars.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());
    }
}
