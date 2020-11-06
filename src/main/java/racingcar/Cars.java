package racingcar;


import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names, RuleStrategy ruleStrategy) {
        this.cars = names.stream().map(name -> new Car(name, ruleStrategy)).collect(Collectors.toList());
    }

    public void move() {
        this.cars.stream().forEach(car -> car.move());
    }

    public List<Integer> getCarPositions() {
        return this.cars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList());
    }

    
}
