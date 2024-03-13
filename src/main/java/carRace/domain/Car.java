package carRace.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {

    private static final int RECORD_STANDARD_NUMBER = 4;

    private final List<Integer> randomNumberHistory = new ArrayList<>();

    private int moveCount = 0;

    public static List<Car> createCars(int carMount) {
        return IntStream.range(0, carMount)
            .mapToObj(i -> new Car())
            .collect(Collectors.toList());
    }

    public List<Integer> randomNumberHistory() {
        return randomNumberHistory;
    }

    public int moveCount() {
        return moveCount;
    }

    public boolean move(int randomNumber) {
        randomNumberHistory.add(randomNumber);
        if (randomNumber >= RECORD_STANDARD_NUMBER) {
            moveCount += 1;
            return true;
        }
        return false;
    }
}
