package step3.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import step3.utils.RandomSingleton;

public class Game {
    static final String INVALID_CAR_NUMBER_MSG = "자동차 개수는 음수가 될 수 없습니다.";
    static final String INVALID_TRY_NUMBER_MSG = "횟수는 음수가 될 수 없습니다.";

    private final int carNumber;
    private final int tryNumber;

    public Game(int carNumber, int tryNumber) {
        if (carNumber < 0) {
            throw new IllegalArgumentException(INVALID_CAR_NUMBER_MSG);
        }

        if (tryNumber < 0) {
            throw new IllegalArgumentException(INVALID_TRY_NUMBER_MSG);
        }

        this.carNumber = carNumber;
        this.tryNumber = tryNumber;
    }

    public List<List<Car>> play() {
        List<List<Car>> results = new ArrayList<>();

        List<Car> previousCars = initCars();

        for (int i = 0; i < tryNumber; ++i) {
            List<Car> carsAfterMove = moveCars(previousCars);
            results.add(carsAfterMove);
            previousCars = carsAfterMove;
        }

        return results.stream()
                .collect(Collectors.toList());
    }

    private List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; ++i) {
            cars.add(Car.init());
        }
        return cars;
    }

    private List<Car> moveCars(List<Car> cars) {
        Random random = RandomSingleton.INSTANCE.getInstance();
        return cars.stream()
                .map(car -> car.move(random.nextInt(10)))
                .collect(Collectors.toList());
    }
}
