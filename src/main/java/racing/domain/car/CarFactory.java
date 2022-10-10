package racing.domain.car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private final MovingStrategy movingStrategy;

    public CarFactory(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public Car create(final String name){
        return new Car(movingStrategy, name);
    }

    public List<Car> create(final String... names){
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(create(name));
        }
        return cars;
    }
}
