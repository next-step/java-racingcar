package racingcar.domain;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        int maxPosition = 0;
        for(Car car : cars) {
            Position position = car.getPosition();
        }
        return null;
    }
}
