package carRace.domain.car;

import carRace.domain.randomNumber.RandomNumber;
import carRace.domain.randomNumber.RandomNumberHistory;
import java.util.Comparator;
import java.util.List;

public class Car implements Comparable<Car> {

    private final CarName carName;

    private final MoveDistance moveDistance;

    private final RandomNumberHistory randomNumberHistory;

    private static final Comparator<Car> COMPARATOR = Comparator.comparingInt(Car::getMoveDistance);

    private static final int RECORD_STANDARD_NUMBER = 4;

    public Car(final CarName carName) {
        this(carName, new MoveDistance(0));
    }

    public Car(final CarName carName, MoveDistance moveDistance) {
        this.carName = carName;
        this.moveDistance = moveDistance;
        randomNumberHistory = new RandomNumberHistory();
    }

    public CarName getCarName() {
        return carName;
    }

    public int getMoveDistance() {
        return moveDistance.getMoveDistance();
    }

    public List<RandomNumber> getRandomNumberHistory() {
        return randomNumberHistory.getRandomNumbers();
    }

    public void move(final RandomNumber randomNumber) {
        randomNumberHistory.addRandomNumber(randomNumber);
        if (randomNumber.getRandomNumber() >= RECORD_STANDARD_NUMBER) {
            moveDistance.plusMoveDistance();
        }
    }

    public boolean isSameMoveDistance(int moveDistance) {
        return this.getMoveDistance() == moveDistance;
    }

    @Override
    public int compareTo(Car other) {
        return COMPARATOR.compare(this, other);
    }
}
