package RacingCar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static String DELIMITER = ",";
    private static int RANDOM_NUMBER_RANGE = 10;

    private List<Car> cars;

    public Cars(String input) {
        cars = Arrays.stream(input.split(DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move(MovingStrategy randomNumber) {
        for (Car car : cars) {
            car.move(randomNumber.moveable(RANDOM_NUMBER_RANGE));
        }
    }
}
