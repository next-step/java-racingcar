package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinningRacingCar {

    public static final int BEGIN_INDEX = 0;
    public static final int INIT_VALUE = 0;
    public static final int CAR_MOVE_STANDARD = 4;
    public static final String CAR_NAME_SEPARATOR = ",";

    private List<Car> cars;

    public int getCarsSize() {
        return cars.size();
    }

    public WinningRacingCar(String carNameInput) {
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

    public List<Car> makeCars(List<Integer> numbers) {
        for (int i = BEGIN_INDEX; i < numbers.size(); i++) {
            makeCars(i, numbers.get(i));
        }
        return cars;
    }

    private void makeCars(int idx, int number) {
        if (isCarMovable(number)) {
            plusMoveCount(idx);
        }
    }

    public boolean isCarMovable(int number) {
        return number >= CAR_MOVE_STANDARD;
    }

    private void plusMoveCount(int idx) {
        cars.get(idx).plusMoveCount();
    }
}
