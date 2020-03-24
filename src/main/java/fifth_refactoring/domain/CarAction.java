package fifth_refactoring.domain;

import fifth_refactoring.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarAction {

    private static final int ALLOW_MOVE_NUMBER = 4;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int RANDOM_MIN_NUMBER = 0;


    public static List<Car> ready(String carName){
        String[] carNameArray = splitCarName(carName);

        return setCar(carNameArray);
    }

    public static String[] splitCarName(String carName) {
        return carName.split(InputView.CAR_NAME_SPLIT_SIGN);
    }

    public static List<Car> setCar(String[] carNameArray) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameArray) {
            Car car = new Car(carName);
            carList.add(car);
        }

        return carList;
    }

    public static void moveCar(List<Car> carList) {
        for (Car car : carList) {
            isMove(car);
        }
    }

    public static void isMove(Car car) {
        if (random() < ALLOW_MOVE_NUMBER) {
            car.move();
        }
    }

    public static int random() {
        int randomValue = new Random().nextInt(RANDOM_MAX_NUMBER + 1) + RANDOM_MIN_NUMBER;

        if (randomValue < RANDOM_MIN_NUMBER || randomValue > RANDOM_MAX_NUMBER) {
            throw new IllegalArgumentException(RANDOM_MIN_NUMBER + "~" + RANDOM_MAX_NUMBER + 1 + "만 허용");
        }

        return randomValue;
    }

}