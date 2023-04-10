package basicgame;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static final String INPUT_ERROR_MESSAGE = "0이나 음수값은 입력하실 수 없습니다.";

    private static int carCount = 0;
    private static int tryCount = 0;

    private static List<Car> cars;

    public static void startGame() {
        input();
        initCar(carCount);

        ResultView.printResultTitle();
        for (int i = 0; i < tryCount; i++) {
            activeCar();
            ResultView.printResultList(cars);
        }
    }

    public static void input() {
        InputView.printCarInput();
        carCount = UserInput.input();

        InputView.printTryInput();
        tryCount = UserInput.input();

        if (carCount <= 0 || tryCount <= 0) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private static void activeCar() {
        for (Car car : cars) {
            car.go();
        }
    }

    private static void initCar(int carCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(new StringBuffer()));
        }
    }

    public static int getCarCount() {
        return carCount;
    }

    public static int getTryCount() {
        return tryCount;
    }
}
