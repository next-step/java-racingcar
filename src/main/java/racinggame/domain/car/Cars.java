package racinggame.domain.car;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.random.GoRule;
import racinggame.domain.winner.Winners;

public class Cars {

    private static final int CAR_INIT_LOCATION = 0;

    private final List<Car> cars = new ArrayList<>();


    public Cars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName, CAR_INIT_LOCATION));
        }
    }

    public void move(GoRule goRule) {
        cars.forEach(car -> car.move(goRule));
    }

    private int findMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = Math.max(car.getLocation(), maxLocation);
        }
        return maxLocation;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public Winners getWinners() {
        return new Winners(cars, findMaxLocation());

    }
}
