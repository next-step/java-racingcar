package cc.oakk.racing.domain;

import cc.oakk.racing.domain.predicate.CarForwardCondition;
import cc.oakk.racing.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private final CarForwardCondition<?> condition;

    public CarFactory(CarForwardCondition<?> condition) {
        if (condition == null) {
            throw new IllegalArgumentException("CarForwardCondition is Null!");
        }
        this.condition = condition;
    }

    public List<Car> createCars(List<String> carNames) {
        Validator.checkList(carNames);
        return carNames.stream()
                .map(s -> new Car(s, condition))
                .collect(Collectors.toList());
    }
}
