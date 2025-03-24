package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String DELIMITER = ",";

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        String[] carNameArray = stripStringArray(splitByDelimiter(carNames, DELIMITER));
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
    }

    public void moveAll(NumberBasedCarMover carMover) {
        for (Car car : cars) {
            car.move(carMover);
        }
    }

    public Winners winners() {
        return new Winners(cars);
    }

    public List<Car> cars() {
        return cars;
    }

    public static String[] splitByDelimiter(String string, String delimiter) {
        return string.split(delimiter);
    }

    public static String[] stripStringArray(String[] array) {
        int length = array.length;
        String[] copyArr = new String[length];
        for (int i = 0; i < length; i++) {
            copyArr[i] = array[i].strip();
        }
        return copyArr;
    }
}
