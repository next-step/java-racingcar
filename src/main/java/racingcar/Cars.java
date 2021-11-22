package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        for (int i = 0; i < cars.size(); i++) {
            Car current = cars.get(i);
            current.move(RandomGenerator.generate());
            ResultView.printCarDistanceWithName(current.getDistance(), current.getCarName());
        }
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = getMaxDistance();
        cars.forEach((car) -> {
            if (car.isWinner(maxDistance)) {
                winners.add(car);
            }
        });
        return winners;
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (int i = 0; i < cars.size(); i++) {
            Car current = cars.get(i);
            maxDistance = Math.max(maxDistance, current.getDistance());
        }
        return maxDistance;
    }
}
