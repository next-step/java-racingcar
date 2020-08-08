package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingRound {
    private List<RacingCar> racingCars;

    public RacingRound(List<RacingCar> cars) {
        this.racingCars = cars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<String> findWinners() {
        final RacingCar maxPositionCar = findMaxPositionCar();
        return findSamePositionCars(maxPositionCar);
    }

    private RacingCar findMaxPositionCar() {
        return racingCars.stream()
                .max(RacingCar::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("참가한 자동차 리스트가 비었습니다."));
    }

    private List<String> findSamePositionCars(RacingCar maxPositionCar) {
        return racingCars.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());
    }
}
