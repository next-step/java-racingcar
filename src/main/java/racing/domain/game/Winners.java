package racing.domain.game;

import racing.domain.car.Car;
import racing.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    public Cars getWinners(Cars cars) {
        List<Car> winners = getWinners(cars, getMaxPosition(cars));
        if (winners.isEmpty()) {
            throw new RuntimeException("우승자가 없습니다.");
        }
        return new Cars(winners);
    }

    private int getMaxPosition(Cars cars) {
        int maxPosition = 0;
        for (Car car : cars.getItems()) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<Car> getWinners(Cars cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars.getItems()) {
            if (car.isSame(maxPosition)) {
                winners.add(car);
            }
        }

        return winners;
    }
}
