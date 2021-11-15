package racingcar;

import racingcar.util.CarMoveManager;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;
    private static final String SPLITTER = ",";

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars doRacing() {
        return new Cars(cars.stream()
                .map(car -> car.move(CarMoveManager.moveValue()))
                .collect(Collectors.toList()));
    }

    public static Cars makeRacingCarsFromName(String carNames) {
        String[] names = carNames.split(SPLITTER);
        return new Cars(Arrays.stream(names)
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList()));
    }

    public List<Car> getWinnerCar() {

        int maxValue = getMaxLocation(cars);
        return cars.stream().filter(car -> car.getLocation() == maxValue).collect(Collectors.toList());
    }

    private int getMaxLocation(List<Car> cars) {
        Optional<Car> maxLocationValueOfCar = cars.stream().max(Comparator.comparing(Car::getLocation));
        return maxLocationValueOfCar.get().getLocation();
    }

    public List<Car> getCars() {
        return cars;
    }
}
