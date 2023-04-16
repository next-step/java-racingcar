package step3.car.game;

import java.util.stream.IntStream;

public class CarGame {
    private final Cars cars;
    private final int moves;
    private final CarsView view;

    public CarGame(int numberOfCars, int numberOfMoves) {
        if (numberOfCars <= 0 || numberOfMoves <= 0) {
            throw new RuntimeException("입력값은 1 이상이어야 합니다.");
        }
        cars = new Cars(numberOfCars);
        moves = numberOfMoves;
        view = new CarsView();
    }

    public CarGame(String[] carNames, int numberOfMoves) {
        if (carNames.length == 0 || numberOfMoves <= 0) {
            throw new RuntimeException("입력값은 1 이상이어야 합니다.");
        }
        cars = new Cars(carNames);
        moves = numberOfMoves;
        view = new CarsView();
    }

    public void start() {
        IntStream.range(0, moves)
                .forEach(countOfMoves -> {
                    cars.move();
                    view.print(cars);
                });
    }
}
