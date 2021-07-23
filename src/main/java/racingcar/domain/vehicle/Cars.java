package racingcar.domain.vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.RandomUtil;

public class Cars {

    private static final int MAX_DRIVE_NUMBER = 10;
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        cars.forEach(this::add);
    }

    public void add(Car car) {
        cars.add(CarFactory.create(car.getName(), car.getDistance()));
    }

    public void doDrive() {
        cars.forEach(car -> car.drive(RandomUtil.nextInt(MAX_DRIVE_NUMBER)));
    }

    public int getFarthestDistance() {
        return cars.stream()
            .max(Comparator.comparing(Car::getDistance))
            .orElseGet(() -> CarFactory.create(""))
            .getDistance();
    }

    public Cars findByDistance(int distance) {
        return new Cars(cars.stream()
            .filter(car -> car.getDistance() == distance)
            .collect(Collectors.toList()));
    }

    public int size() {
        return cars.size();
    }

    public String getCarName(int index) {
        return cars.get(index).getName();
    }

    public List<String> getCarNames() {
        return cars.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public int getDistance(int index) {
        return cars.get(index).getDistance();
    }
}

