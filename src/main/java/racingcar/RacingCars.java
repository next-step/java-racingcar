package racingcar;

import common.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCars {

    private List<Car> cars = new ArrayList<>();
    public RacingCars(String inputName) {
        this.cars = createCars(splitNames(inputName));
    }

    private String[] splitNames(String inputName) {
        return StringUtils.split(inputName, ",");
    }


    public int numberOfParticipants() {
        return cars.size();
    }


    public void moveCar(Movable movable) {
        for (Car car : cars) {
            movable.moveCar(car);
        }
    }


    private List<Car> createCars(String[] names) {
        return Stream.of(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getRacingCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public List<Car> getWinners() {
        Car carOfMaxPosition = getCarOfMaxPosition();
        return cars.stream()
                .filter(it -> it.getPosition() == carOfMaxPosition.getPosition())
                .collect(Collectors.toList());
    }

    private Car getCarOfMaxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(() -> new IllegalStateException("car.position cannot get max"));
    }
}
