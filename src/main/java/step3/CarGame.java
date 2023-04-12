package step3;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class CarGame {
    private final static Random random = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;
    private final List<Car> cars;
    private final int moves;

    public CarGame(int numberOfCars, int numberOfMoves) {
        if (numberOfCars <= 0 || numberOfMoves <= 0) {
            throw new RuntimeException("입력값은 1 이상이어야 합니다.");
        }
        cars = Collections.nCopies(numberOfCars, new Car());
        moves = numberOfMoves;
    }

    public void start() {
        IntStream.range(0, moves)
                .forEach(
                        value -> cars.forEach(
                                car -> car.move(randomNumber())
                        )
                );
    }

    private int randomNumber() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
