package RacingCar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingWinnerFinder {
    public RacingCar[] findWinners(RacingCar[] cars, int maxCarPosition) {
        List<RacingCar> winningCars = new ArrayList<>();

        for (RacingCar car : cars) {
            if (maxCarPosition == car.position()) {
                winningCars.add(car);
            }
        }

        return winningCars.toArray(new RacingCar[winningCars.size()]);
    }
}

