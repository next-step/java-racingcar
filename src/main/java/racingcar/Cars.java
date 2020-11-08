package racingcar;


import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move(RuleStrategy ruleStrategy) {
        this.cars.forEach(car -> car.move(ruleStrategy));
    }

    public List<Car> getCarList() {
        return cars;
    }
}
