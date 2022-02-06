package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private static final int RANDOM_BOUND_VALUE = 9;

    private List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        for (String carName : carNames.split(",")) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> moveCars() {
        Random random = new Random();
        for (Car car : cars) {
            int moveOrNot = random.nextInt(RANDOM_BOUND_VALUE);
            car.moveForward(moveOrNot);
        }
        return cars;
    }

}
