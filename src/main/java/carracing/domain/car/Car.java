package carracing.domain.car;

import carracing.domain.car.strategy.MovingStrategy;
import carracing.domain.NameOfCar;

public class Car {
    private static final int DEFAULT_INCREASE_AMOUNT = 1;
    private static final int NO_INCREASE_AMOUNT = 0;

    private final NameOfCar nameOfCar;
    private final PositionOfCar positionOfCar;

    private Car(final NameOfCar nameOfCar) {
        this.nameOfCar = nameOfCar;
        this.positionOfCar = PositionOfCar.startPositionOfCar();
    }

    public static Car newCar(final NameOfCar nameOfCar) {
        return new Car(nameOfCar);
    }

    public int position() {
        return positionOfCar.position();
    }

    public void move(final MovingStrategy movingStrategy) {
        int increaseAmount = movingStrategy.isMovable() ? DEFAULT_INCREASE_AMOUNT : NO_INCREASE_AMOUNT;
        positionOfCar.increase(increaseAmount);
    }

    public RaceRecordOfCar raceRecord() {
        return RaceRecordOfCar.newRaceRecord(nameOfCar.carName(), positionOfCar.position(), positionOfCar.positionHistory());
    }
}
