package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.racingcar.domain.result.DriveResult;
import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;
import camp.nextstep.edu.racingcar.domain.result.RoundResult;
import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(DriveStrategy driveStrategy, String carNames) {
        this.cars = initializeCars(driveStrategy, carNames);
    }

    private List<Car> initializeCars(DriveStrategy driveStrategy, String carNames) {
        String[] arrCarNames = carNames.split(",");

        final List<Car> cars = new ArrayList<>();
        for (String carName : arrCarNames) {
            Car car = new Car(carName.trim(), driveStrategy);
            cars.add(car);
        }
        return cars;
    }

    public RoundResult drive() {
        RoundResult roundResult = new RoundResult();

        for (Car car : cars) {
            DriveResult driveResult = car.drive();
            roundResult.report(driveResult);
        }
        return roundResult;
    }
}
