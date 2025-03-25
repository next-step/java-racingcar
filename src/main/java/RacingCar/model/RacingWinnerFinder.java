package RacingCar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingWinnerFinder {
    private RacingCar[] cars;
    private List<RacingCar> winningCars;

    public RacingWinnerFinder(RacingCar[] cars) {
        this.cars = cars;
        this.winningCars = new ArrayList<>();
    }

    public RacingCar[] findWinners(int maxCarPosition) {
        for (RacingCar car : cars) {
            if (maxCarPosition == car.position()) {
                this.winningCars.add(car);
            }
        }

        return winningCars.toArray(new RacingCar[winningCars.size()]);
    }
}

