package carracing.domain.game;

import carracing.domain.car.Car;
import carracing.domain.car.Cars;
import carracing.domain.car.Winners;

import java.util.ArrayList;
import java.util.List;

public class MaxMoving implements WinnerStrategy {
    @Override
    public Winners winners(Cars cars) {
        int maxMovingDistance = maxMovingDistance(cars);
        Cars winners = winnersWithMaxMovingDistance(cars, maxMovingDistance);

        return new Winners(winners);
    }

    private int maxMovingDistance(Cars cars) {
        int maxMovingDistance = 0;

        for (Car car : cars) {
            maxMovingDistance = car.maxDistance(maxMovingDistance);
        }

        return maxMovingDistance;
    }

    private Cars winnersWithMaxMovingDistance(Cars cars, int maxMovingDistance) {
        List<Car> winnerCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.sameDistance(maxMovingDistance)) {
                winnerCars.add(car);
            }
        }

        return new Cars(winnerCars);
    }
}
