package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.racingcar.domain.result.DriveResult;
import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;
import camp.nextstep.edu.racingcar.domain.result.RoundResult;
import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final DriveStrategy driveStrategy;
    private final List<Car> cars;

    public Cars(DriveStrategy driveStrategy, int carAmount) {
        this.driveStrategy = driveStrategy;
        this.cars = initializeCars(carAmount);
    }

    private List<Car> initializeCars(int carAmount) {
        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carAmount; i++) {
            Car car = new Car(driveStrategy);
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
