package racingcar.domain;

import racingcar.strategy.MovingStrategy;
import racingcar.util.InputCarNameSplitUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars of(String[] carsNames) {
        List<Car> cars = new ArrayList<Car>();

        for (int i = 0; i < carsNames.length; i++) {
            Car car = new Car(new CarName(carsNames[i]));
            cars.add(car);
        }
        return Cars.of(cars);
    }

    public static Cars of(String carNames) {
        String[] carsNames = InputCarNameSplitUtils.getSplitStringArray(carNames);
        return Cars.of(carsNames);
    }

    public int getCarsCount() {
        return cars.size();
    }

    public List<Position> getCarsPositions() {
        return cars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList());
    }

    public List<CarName> getNames() {
        return cars.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    public void move(MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

}
