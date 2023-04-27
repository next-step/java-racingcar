package domain.game;

import java.util.ArrayList;
import java.util.List;

import domain.cars.RacingCar;
import domain.cars.RacingCars;

public class Winners {
    private List<String> winners;

    public Winners(RacingCars racingCars) {
        this.winners = new ArrayList<>();
        int maxDistance = racingCars.getMaxDistance();
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            findWinners(maxDistance, racingCar);
        }
    }

    private void findWinners(int maxDistance, RacingCar racingCar) {
        if (racingCar.isSameDistance(maxDistance)) {
            winners.add(racingCar.getName());
        }
    }

    public List<String> getWinners() {
        return winners;
    }
}
