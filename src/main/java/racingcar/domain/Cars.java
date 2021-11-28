package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;
    private static final String SPLITTER = ",";


    private static final int MAX_CAR_NAME = 5;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public static Cars makeRacingCarsFromName(String carNames) {
        String[] names = carNames.split(SPLITTER);

        validateNames(names);

        return new Cars(Arrays.stream(names)
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList()));
    }

    private static void validateNames(String[] names) {

        Arrays.stream(names).forEach(name -> {
            if (name.length() > MAX_CAR_NAME) {
                throw new IllegalArgumentException("Car name should be less than 5 characters");
            }
        });
    }

    public void doRacing() {
        cars.forEach(car -> car.move(getRandomValue()));
    }

    private RandomValue getRandomValue() {
        return new RandomValue(NumberGenerator.generate());
    }

    public List<Car> getWinnerCar() {
        int maxValue = getMaxLocation(cars);
        return cars.stream().filter(car -> car.getLocation() == maxValue).collect(Collectors.toList());
    }

    private int getMaxLocation(List<Car> cars) {
        return cars.stream().mapToInt(Car::getLocation).max().orElse(0);
    }

}
