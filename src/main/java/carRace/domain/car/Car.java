package carRace.domain.car;

import carRace.domain.randomNumber.RandomNumber;
import carRace.domain.randomNumber.RandomNumberHistory;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {

    private final RandomNumberHistory randomNumberHistory = new RandomNumberHistory();

    private MoveDistance moveDistance;

    private final String carName;

    private static final int RECORD_STANDARD_NUMBER = 4;

    public Car(final String carName) {
        this(carName, new MoveDistance(0));
    }

    public Car(final String carName, MoveDistance moveDistance) {
        this.carName = carName;
        this.moveDistance = moveDistance;
    }

    public MoveDistance getMoveDistance() {
        return moveDistance;
    }

    public static List<Car> createCars(final List<String> carNames) {
        return IntStream.range(0, carNames.size())
            .mapToObj(carNumber -> new Car(carNames.get(carNumber)))
            .collect(Collectors.toList());
    }

    public RandomNumberHistory getRandomNumberHistory() {
        return randomNumberHistory;
    }

    public String carName() {
        return carName;
    }

    public void move(RandomNumber randomNumber) {
        randomNumberHistory.addRandomNumber(randomNumber);
        if (randomNumber.getRandomNumber() >= RECORD_STANDARD_NUMBER) {
            moveDistance.plusMoveDistance();
        }
    }
}
