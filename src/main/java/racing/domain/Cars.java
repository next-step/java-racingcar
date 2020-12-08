package racing.domain;

import racing.domain.condition.MovingCondition;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames, MovingCondition condition) {
        AtomicInteger index = new AtomicInteger();
        cars = Stream.generate(() -> new Car(condition, carNames.get(index.getAndIncrement())))
                .limit(carNames.size())
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }
}