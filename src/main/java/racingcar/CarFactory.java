package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private final List<String> namesOfCars;

    public CarFactory(String[] namesOfCars) {
        this.namesOfCars = Arrays.stream(namesOfCars).collect(Collectors.toList());
    }

    public Cars buildCars() {
        Cars cars = new Cars();

        namesOfCars.forEach( name ->
                cars.add(new Car(name)));

        return cars;
    }
}
