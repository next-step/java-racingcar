package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static final int BEGIN_INDEX = 0;
    public static final int INIT_VALUE = 0;
    public static final int CAR_MOVE_STANDARD = 4;
    public static final String CAR_NAME_SEPARATOR = ",";

    private List<Car> cars;

    public RacingCar(String carNameInput) {
        String[] carNames = splitCarNameInput(carNameInput);
        List<Car> cars = new ArrayList<>();

        for (int i = BEGIN_INDEX; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], INIT_VALUE));
        }
        this.cars = cars;
    }

    public int getCarsSize() {
        return cars.size();
    }

    public List<String> getWinnerNames() {
        return getWinnerNames(getMaxMoveCount());
    }

    private List<String> getWinnerNames(int maxMoveCount) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            addWinnerNames(maxMoveCount, winnerNames, car);
        }
        return winnerNames;
    }

    private void addWinnerNames(int maxMoveCount, List<String> winnerNames, Car car) {
        if(car.getMoveCount() == maxMoveCount) {
            winnerNames.add(car.getName());
        }
    }

    private int getMaxMoveCount() {
        int maxMoveCount = INIT_VALUE;
        for (Car car : cars) {
            maxMoveCount = getMaxMoveCount(maxMoveCount, car);
        }
        return maxMoveCount;
    }

    private int getMaxMoveCount(int maxMoveCount, Car car) {
        if(car.getMoveCount() > maxMoveCount) {
            maxMoveCount = car.getMoveCount();
        }
        return maxMoveCount;
    }

    private String[] splitCarNameInput(String carNameInput) {
        return carNameInput.split(CAR_NAME_SEPARATOR);
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
