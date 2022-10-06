package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private final MovingRule movingRule;

    public CarFactory(MovingRule movingRule) {
        this.movingRule = movingRule;
    }

    public Car create(final String name){
        return new Car(movingRule, name);
    }

    public List<Car> create(final String... names){
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(create(name));
        }
        return cars;
    }
}
