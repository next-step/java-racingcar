package carRace.domain.car;

import carRace.domain.randomNumber.RandomNumber;
import carRace.domain.randomNumber.RandomNumberHistory;

public class Car {

    private final CarName carName;

    private final MoveDistance moveDistance;

    private final RandomNumberHistory randomNumberHistory = new RandomNumberHistory();

    private static final int RECORD_STANDARD_NUMBER = 4;

    public Car(final CarName carName) {
        this(carName, new MoveDistance(0));
    }

    public Car(final CarName carName, MoveDistance moveDistance) {
        this.carName = carName;
        this.moveDistance = moveDistance;
    }

    public CarName getCarName() {
        return carName;
    }

    public MoveDistance getMoveDistance() {
        return moveDistance;
    }

    public RandomNumberHistory getRandomNumberHistory() {
        return randomNumberHistory;
    }

    public void move(RandomNumber randomNumber) {
        randomNumberHistory.addRandomNumber(randomNumber);
        if (randomNumber.getRandomNumber() >= RECORD_STANDARD_NUMBER) {
            moveDistance.plusMoveDistance();
        }
    }
}
