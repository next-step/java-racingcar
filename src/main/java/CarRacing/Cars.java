package CarRacing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private MovigStrategy movigStrategy;

    public Cars(String carNames) {
        Arrays.asList(carNames.split(",")).forEach(s -> cars.add(new Car(new CarName(s))));
        movigStrategy = new RandomMove();
    }

    public void moveAll() {
        cars.forEach(s -> s.move(movigStrategy));
    }

    public List<Car> getCars() {
        return cars;
    }
}