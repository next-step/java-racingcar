package refactoring.racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    public void moveAllCars() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move();
        }
    }

    public List<RacingCar> getWinners() {
        CarPosition maxPosition = new CarPosition(0);
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition().compareTo(maxPosition) > 0) {
                maxPosition = racingCar.getPosition();
            }
        }

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition().compareTo(maxPosition) == 0) {
                winners.add(racingCar);
            }
        }
        return winners;
    }
}
