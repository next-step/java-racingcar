package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import static racing.domain.CarRacingProperty.CAR_NAME_SEPARATOR;

public class Cars {

    private final List<Car> cars;

    public Cars(String inputNames) {
        cars = new ArrayList<>();
        parseInputNames(inputNames);
    }

    public int getCarCount() {
        return cars.size();
    }

    public String[] getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public int getMaxMovedDistance() {
        return Collections.max(cars, Comparator.comparingInt(Car::getDistance))
            .getDistance();
    }

    public void forEach(Consumer<Car> action) {
        cars.forEach(action);
    }

    private void parseInputNames(String inputNames) {
        String[] names = inputNames.split(CAR_NAME_SEPARATOR);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }
}
