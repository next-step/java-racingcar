package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.racingcar.domain.result.DriveResult;
import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;

public class Car {

    private final DriveStrategy driveStrategy;
    private int drivenDistance;

    public Car(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
        this.drivenDistance = 0;
    }

    public DriveResult drive() {
        if (driveStrategy.canDrive()) {
            this.drivenDistance++;
        }
        return new DriveResult(drivenDistance);
    }
}
