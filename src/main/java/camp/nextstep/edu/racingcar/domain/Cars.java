package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.racingcar.domain.result.DriveResult;
import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;
import camp.nextstep.edu.racingcar.domain.result.RoundResult;

public class Cars {

    private final DriveStrategy driveStrategy;
    private final int carAmount;
    private final Car[] cars;

    public Cars(DriveStrategy driveStrategy, int carAmount) {
        this.driveStrategy = driveStrategy;
        this.carAmount = carAmount;

        cars = initializeCars(carAmount);
    }

    private Car[] initializeCars(int carAmount) {
        final Car[] cars = new Car[carAmount];
        for (int i = 0; i < carAmount; i++) {
            cars[i] = new Car(driveStrategy);
        }
        return cars;
    }

    public RoundResult drive() {
        RoundResult roundResult = new RoundResult();

        for (int i = 0; i < carAmount; i++) {
            DriveResult driveResult = cars[i].drive();
            roundResult.report(driveResult);
        }

        return roundResult;
    }
}
