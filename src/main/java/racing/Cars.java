package racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;
    private final MovingCondition condition;

    public Cars(int count, MovingCondition condition) {
        cars = Stream.generate(Car::new)
                .limit(count)
                .collect(Collectors.toList());
        this.condition = condition;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        cars.forEach(car -> car.move(condition.getCondition()));
    }
}
