package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static final int BEGIN_INDEX = 0;
    public static final int INIT_VALUE = 0;
    public static final String CAR_NAME_SEPARATOR = ",";

    private final List<Car> cars;

    public RacingCar(String carNameInput) {
        String[] carNames = splitCarNameInput(carNameInput);
        List<Car> cars = new ArrayList<>();

        for (int i = BEGIN_INDEX; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], INIT_VALUE));
        }
        this.cars = cars;
    }

    private String[] splitCarNameInput(String carNameInput) {
        return carNameInput.split(CAR_NAME_SEPARATOR);
    }

    public int carsSize() {
        return cars.size();
    }

    public List<Car> winningCars() {
        return makeWinningCars(maxMoveCount());
    }

    private List<Car> makeWinningCars(int maxMoveCount) {
        List<Car> winningCars = new ArrayList<>();
        for (Car car : cars) {
            addWinningCar(maxMoveCount, winningCars, car);
        }
        return winningCars;
    }

    private void addWinningCar(int maxMoveCount, List<Car> winningCars, Car car) {
        if(car.moveCountIsEqualTo(maxMoveCount)) {
            winningCars.add(car);
        }
    }

    private int maxMoveCount() {
        int maxMoveCount = INIT_VALUE;
        for (Car car : cars) {
            maxMoveCount = makeMaxMoveCount(maxMoveCount, car);
        }
        return maxMoveCount;
    }

    private int makeMaxMoveCount(int maxMoveCount, Car car) {
        if(car.moveCountIsGreaterThan(maxMoveCount)) {
            maxMoveCount = car.moveCount();
        }
        return maxMoveCount;
    }

    public List<Car> makeMoveCounts(List<Integer> numbers) {
        for (int i = BEGIN_INDEX; i < numbers.size(); i++) {
            cars.get(i).makeMoveCount(numbers.get(i));
        }
        return cars;
    }

}
