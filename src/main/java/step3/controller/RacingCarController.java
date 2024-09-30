package step3.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import step3.model.Car;
import step3.view.InputView;
import step3.view.OutputView;

public class RacingCarController {
    private static final int MOVE_MIN_NUMBER = 4;
    private static final int RANDOM_MAX_NUMBER = 10;
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
        OutputView.printRacingResult();
        for (int i = 0; i < tryCount; i++) {
            processRound(carList);
            System.out.println();
        }
    }

    private void processRound(final List<Car> carList) {
        for (Car car : carList) {
            moveCarAndPrintProgress(car);
        }
    }

    private void moveCarAndPrintProgress(final Car car) {
        if (random.nextInt(RANDOM_MAX_NUMBER) >= MOVE_MIN_NUMBER) {
            car.move();
        }
        OutputView.printRacingProgress(car);
    }
}
