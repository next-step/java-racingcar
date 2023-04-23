package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private static final int BEGIN_INDEX = 0;
    private static final int INIT_VALUE = 0;
    private static final String CAR_NAME_SEPARATOR = ",";

    private final Cars cars;

    public CarRacingGame(String input) {
        this.cars = initCars(input);
    }

    private Cars initCars(String input) {
        String[] carNames = splitCarName(input);

        List<Car> cars = new ArrayList<>();
        for (int i = BEGIN_INDEX; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], INIT_VALUE));
        }
        return new Cars(cars);
    }

    private String[] splitCarName(String input) {
        return input.split(CAR_NAME_SEPARATOR);
    }

    public int carSize() {
        return this.cars.size();
    }

    public List<Car> moveCounts(List<Integer> numbers) {
        return this.cars.moveCount(numbers);
    }

    public List<Car> winningCars() {
        return this.cars.winningCars();
    }
}
