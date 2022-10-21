package nextstep.javaracingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private final String CAR_NAME_DELIMITER = ",";
    private final List<Car> cars;
    private final Round round;

    public CarRacingGame(final PositiveNumber carCount, final Round round, final MovingStrategy movingStrategy) {

        this.cars = this.createCars(carCount, movingStrategy);
        this.round = round;
    }

    public CarRacingGame(final String carNames, final Round round, final MovingStrategy movingStrategy) {
        this.cars = this.createCars(carNames, movingStrategy);
        this.round = round;
    }

    private List<Car> createCars(final PositiveNumber carCount, final MovingStrategy movingStrategy) {
        final List<CarName> defaultCarNames = new ArrayList<>();
        carCount.forEach(i -> defaultCarNames.add(new CarName(String.valueOf(i))));
        return createCars(defaultCarNames, movingStrategy);
    }

    private List<Car> createCars(final String carNames, final MovingStrategy movingStrategy) {
        final String[] splitNames = carNames.split(CAR_NAME_DELIMITER);
        final List<CarName> carNameList = new ArrayList<>();
        for (final String splitName : splitNames) {
            carNameList.add(new CarName(splitName));
        }
        return createCars(carNameList, movingStrategy);
    }

    private List<Car> createCars(final List<CarName> carNames, final MovingStrategy movingStrategy) {
        final List<Car> initCars = new ArrayList<>();
        carNames.forEach(name -> initCars.add(new Car(name, movingStrategy)));
        return initCars;
    }

    public boolean hasNextRound() {
        return this.round.hasNextRound();
    }

    public CarRacingResult runRound() {
        for (Car car : this.cars) {
            car.move();
        }
        this.round.run();
        return result();
    }

    public CarRacingResult result() {
        final List<CarDrivingResult> drivingResults = cars.stream().map(Car::drivingResult).collect(Collectors.toList());
        return new CarRacingResult(drivingResults);
    }
}
