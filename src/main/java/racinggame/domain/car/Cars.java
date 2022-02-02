package racinggame.domain.car;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.random.GoRule;

public class Cars {

    private static final int CAR_INIT_LOCATION = 0;

    private final List<Car> cars = new ArrayList<>();

    public Cars(final String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName, CAR_INIT_LOCATION));
        }
    }

    public Cars move(final GoRule goRule) {
        cars.forEach(car -> car.move(goRule));
        return this;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

}
