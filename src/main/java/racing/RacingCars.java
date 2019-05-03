package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = Collections.unmodifiableList(racingCars);
    }

    public int count() {
        return racingCars.size();
    }

    public void add(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    public List<RacingCar> getObject() {
        return racingCars;
    }

    public List<RacingCar> findWinners() {
        int maxCoordinate = maxCoordinate();
        return getWinners(maxCoordinate);
    }

    private int maxCoordinate() {
        int maxPosition = 0;
        for (RacingCar car: racingCars) {
            maxPosition = car.findMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<RacingCar> getWinners(int maxCoordinate) {
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar car: racingCars) {
            if (car.isMaxPosition(maxCoordinate)) {
                winners.add(car);
            }
        }
        return winners;
    }
}
