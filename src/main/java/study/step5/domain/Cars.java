package study.step5.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        Position maxPosition = new Position(0);
        for(Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }

        List<Car> winners = new ArrayList<>();
        for(Car car : cars) {
            if(car.getPosition().equals(maxPosition)) {
                winners.add(car);
            }
        }

        return winners;
    }
}
