package newcarracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(List<RacingCar> racingCars) throws CloneNotSupportedException {
        for (RacingCar car : racingCars) {
            this.racingCars.add((RacingCar) car.clone());
        }
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public List<RacingCar> getWinners() {
        int maxPosition = findMaxPosition();
        return this.racingCars.stream().filter(car -> car.isMaxPosition(maxPosition)).collect(Collectors.toList());
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (RacingCar car : this.racingCars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }
}
