package study.racing.factory;

import study.racing.domain.Car;
import study.racing.domain.MovingCondition;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarFactory {

    public static List<Car> createCars(String[] names, MovingCondition movingCondition) {
        return IntStream.range(0, names.length)
                .mapToObj(i -> new Car(names[i], movingCondition))
                .collect(Collectors.toUnmodifiableList());
    }
}
