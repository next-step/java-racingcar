package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    public static final int BEGIN_INDEX = 0;
    public static final int INIT_VALUE = 0;
    public static final String CAR_NAME_SEPARATOR = ",";

    private final Cars cars;

    public CarRacingGame(String carNameInput) {
        this.cars = new Cars(makeCars(splitCarNameInput(carNameInput)));
    }

    private List<Car> makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = BEGIN_INDEX; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], INIT_VALUE));
        }
        return cars;
    }

    private String[] splitCarNameInput(String carNameInput) {
        return carNameInput.split(CAR_NAME_SEPARATOR);
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
