package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.racingcar.domain.result.DriveResult;
import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;

public class Car {

    private final DriveStrategy driveStrategy;
    private final String name;
    private int drivenDistance;

    public Car(String name, DriveStrategy driveStrategy) {
        validateName(name);

        this.driveStrategy = driveStrategy;
        this.name = name;
        this.drivenDistance = 0;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백이 될 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5자까지만 가능합니다.");
        }
    }

    public DriveResult drive() {
        if (driveStrategy.canDrive()) {
            this.drivenDistance++;
        }
        return new DriveResult(drivenDistance);
    }

    public String name() {
        return this.name;
    }
}
