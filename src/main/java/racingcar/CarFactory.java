package racingcar;

import java.util.Arrays;

public class CarFactory {

    private final String[] namesOfCars;

    public CarFactory(String[] namesOfCars) {
        this.namesOfCars = namesOfCars;
    }

    public Cars buildCars() {
        Cars cars = new Cars();

        Arrays.stream(namesOfCars)
                .forEach( name ->
                        cars.add(new Car(name))
                );

        return cars;
    }
}
