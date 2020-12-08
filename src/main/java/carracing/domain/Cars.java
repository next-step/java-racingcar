package carracing.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 경주를 같이하는 자동차들을 표현한 클래스
 */
public class Cars {
    private List<Car> cars;

    public Cars(int numberOfCars) {
        initiateCars(numberOfCars);
    }

    private void initiateCars(int numberOfCars) {
        cars = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public void moveCars(MovementPolicy movementPolicy) {
        cars.forEach(car -> car.move(movementPolicy));
    }

    public List<Car> getCars() {
        return cars;
    }
}
