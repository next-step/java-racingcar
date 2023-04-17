package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static final int BEGIN_INDEX = 0;
    public static final int INIT_VALUE = 0;
    public static final int CAR_MOVE_STANDARD = 4;
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

    public List<String> winningCars() {
        return makeWinningCars(maxMoveCount());
    }

    private List<String> makeWinningCars(int maxMoveCount) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            addWinnerNames(maxMoveCount, winnerNames, car);
        }
        return winnerNames;
    }

    private void addWinnerNames(int maxMoveCount, List<String> winnerNames, Car car) {
        if(car.moveCount() == maxMoveCount) {
            winnerNames.add(car.name());
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
            makeMoveCount(i, numbers.get(i));
        }
        return cars;
    }

    private void makeMoveCount(int idx, int number) {
        if (isCarMovable(number)) {
            plusMoveCount(idx);
        }
    }

    private boolean isCarMovable(int number) {
        return number >= CAR_MOVE_STANDARD;
    }

    private void plusMoveCount(int idx) {
        cars.get(idx).plusMoveCount();
    }
}
