package step3.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import step3.model.Car;
import step3.view.InputView;
import step3.view.OutputView;

public class RacingCarController {
    private static final int MOVE_MIN_NUMBER = 4;
    private static final Random random = new Random();

    public RacingCarController() {
    }

    public void racing() {
        int carCount = InputView.getCarCount();
        int tryCount = InputView.getTryCount();

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        for (int i = 0; i < tryCount; i++) {
            for (Car car : carList) {
                if (random.nextInt() >= MOVE_MIN_NUMBER) {
                    car.move();
                }
                OutputView.printRacingResult(carList);
            }
        }

    }

}
