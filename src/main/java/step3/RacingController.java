package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    private static final int ACCEPT_MOVE_NUMBER = 4;

    public static void run() {
        InputView inputView = new InputView();
        int racingCarNumber = inputView.inputRacingCarCount();
        int tryCountNumber = inputView.inputTryCount();

        game(racingCarNumber, tryCountNumber);
    }

    public static List<Car> createCar(final int racingCarCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < racingCarCount; i++) {
            Car car = new Car();
            cars.add(car);
        }
        return cars;
    }

    public static void tryMoveCar(final Car car) {
        int randomNumber = RandomUtils.generateRandomNumber();
        if (isMove(randomNumber)) {
            car.moveCar();
        }
    }

    public static void game(final int tryCountNumber, final int racingCarNumber) {
        List<Car> cars = createCar(racingCarNumber);

        for (int i = 0; i < tryCountNumber; i++) {
            cars.stream().forEach(car -> tryMoveCar(car));
        }
    }

    public static boolean isMove(final int randomNumber) {
        return randomNumber >= ACCEPT_MOVE_NUMBER;
    }
}
