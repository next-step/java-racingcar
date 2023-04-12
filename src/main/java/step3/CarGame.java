package step3;

import java.util.stream.IntStream;

public class CarGame {
    private final Cars cars;
    private final int moves;

    public CarGame(int numberOfCars, int numberOfMoves) {
        if (numberOfCars <= 0 || numberOfMoves <= 0) {
            throw new RuntimeException("입력값은 1 이상이어야 합니다.");
        }
        cars = new Cars(numberOfCars);
        moves = numberOfMoves;
    }

    public void start() {
        IntStream.range(0, moves)
                .forEach(countOfMoves -> cars.move());
    }
}
