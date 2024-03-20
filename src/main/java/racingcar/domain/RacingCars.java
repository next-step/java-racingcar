package racingcar.domain;

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

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    private String[] splitNames(String inputName) {
        return StringUtils.split(inputName, ",");
    }


    public int numberOfParticipants() {
        return cars.size();
    }


    public void moveCar(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
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
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(it -> it.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .map(Car::getPosition)
                .orElseThrow(() -> new IllegalStateException("car.position cannot get max"));
    }
}
