package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racinggame.domain.random.RandomGenerator;
import racinggame.domain.random.RandomRule;

public class Cars {

    private static final int CAR_INIT_LOCATION = 0;

    private final List<Car> cars = new ArrayList<>();


    public Cars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName, CAR_INIT_LOCATION));
        }
    }

    public void move(RandomRule randomRule) {
        cars.forEach(car -> car.move(randomRule));
    }

    public int findMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = Math.max(car.getLocation(), maxLocation);
        }
        return maxLocation;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

}
