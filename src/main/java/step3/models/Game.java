package step3.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import step3.utils.RandomSingleton;

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

    public List<List<Car>> play() {
        List<List<Car>> results = new ArrayList<>();

        List<Car> previousCars = List.copyOf(carList);

        for (int i = 0; i < tryNumber; ++i) {
            List<Car> carsAfterMove = moveCars(previousCars);
            results.add(carsAfterMove);
            previousCars = carsAfterMove;
        }

        return results.stream()
                .collect(Collectors.toList());
    }

    private List<Car> moveCars(List<Car> cars) {
        Random random = RandomSingleton.INSTANCE.getInstance();
        return cars.stream()
                .map(car -> car.move(random.nextInt(10)))
                .collect(Collectors.toList());
    }
}
