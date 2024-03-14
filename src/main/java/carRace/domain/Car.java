package carRace.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {

    private static final int RECORD_STANDARD_NUMBER = 4;

    private final List<Integer> randomNumberHistory = new ArrayList<>();

    private final String carName;

    private int moveCount;

    public Car(final String carName) {
        this(carName, 0);
    }

    public Car(final String carName, int moveCount) {
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public static List<Car> createCars(final List<String> carNames) {
        return IntStream.range(0, carNames.size())
            .mapToObj(carNumber -> new Car(carNames.get(carNumber))).collect(Collectors.toList());
    }

    public List<Integer> randomNumberHistory() {
        return randomNumberHistory;
    }

    public int moveCount() {
        return moveCount;
    }

    public String carName() {
        return carName;
    }

    public void move(int randomNumber) {
        randomNumberHistory.add(randomNumber);
        if (randomNumber >= RECORD_STANDARD_NUMBER) {
            moveCount += 1;
        }
    }
}
