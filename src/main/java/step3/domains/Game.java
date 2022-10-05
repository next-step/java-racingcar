package step3.domains;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private static final String INVALID_TRY_NUMBER_MSG = "횟수는 음수가 될 수 없습니다.";

    private final List<Car> carList;
    private final int tryNumber;

    public Game(List<Car> carList, int tryNumber) {
        if (tryNumber < 0) {
            throw new IllegalArgumentException(INVALID_TRY_NUMBER_MSG);
        }

        this.carList = carList;
        this.tryNumber = tryNumber;
    }

    public GameResult play() {
        GameResult results = GameResult.init();

        List<Car> previousCars = List.copyOf(carList);

        for (int i = 0; i < tryNumber; ++i) {
            List<Car> carsAfterMove = moveCars(previousCars);
            results.addResult(carsAfterMove);
            previousCars = carsAfterMove;
        }

        return results;
    }

    private List<Car> moveCars(List<Car> cars) {
        return cars.stream()
                .map(car -> car.move(new RandomMovingStrategy()))
                .collect(Collectors.toList());
    }
}
