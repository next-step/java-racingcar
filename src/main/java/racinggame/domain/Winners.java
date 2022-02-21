package racinggame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<RacingCar> racingCars;

    public Winners(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return racingCars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(RacingCar::getCarName)
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        List<Integer> carPositions = racingCars.stream()
            .map(RacingCar::getPosition)
            .collect(Collectors.toList());
        return Collections.max(carPositions);
    }

}
