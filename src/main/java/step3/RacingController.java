package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    public static void run() {
        InputView inputView = new InputView();
        inputView.inputRacingCarCount();
        inputView.inputTryCount();
    }

    public List<Car> initCar(int racingCarCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < racingCarCount; i++) {
            Car car = new Car();
            cars.add(car);
        }
        return cars;
    }
}
