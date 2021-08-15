package racingcargame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private final List<String> carNames;

    public Winner(List<RacingCar> cars) {
        carNames = findWinners(cars);
    }

    private List<String> findWinners(List<RacingCar> cars) {
        cars.sort(Collections.reverseOrder());
        RacingCar winner = cars.get(0);
        return cars.stream()
                .filter(car -> car.isWinner(winner.showDistance()))
                .map(RacingCar::showCarName)
                .collect(Collectors.toList());
    }

    public List<String> getCarNames() {
        return carNames;
    }
}