package CarRacing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        Function<CarName, Car> carFunction = Car::new;
        Arrays.asList(carNames.split(",")).forEach(s -> cars.add(carFunction.apply(new CarName(s))));
    }

    public void moveAll(MovigStrategy movigStrategy) {
        cars.forEach(s -> s.move(movigStrategy));
    }

    public List<Car> getCars() {
        return cars;
    }
}