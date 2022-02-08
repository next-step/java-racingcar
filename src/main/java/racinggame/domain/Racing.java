package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private static final int MAX_RANGE = 10;

    private List<Car> cars = new ArrayList<>();

    public Racing() {
    }

    public void registerCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(Car.of(carName));
        }
    }

    public void race() {
        for (Car car : cars) {
            int randomNumber = makeRandomNumber();
            car.moveForward(randomNumber);
        }
    }

    private int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_RANGE);
    }

    public List<Car> getCarInfo() {
        return cars;
    }
}
