package step3.controller;

import java.util.ArrayList;
import java.util.List;
import step3.model.Car;
import step3.view.InputView;
import step3.view.OutputView;

public class RacingCarController {
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
        }
    }

    private void processRound(final List<Car> carList) {
        for (Car car : carList) {
            moveCarAndPrintProgress(car);
        }
        System.out.println();
    }

    private void moveCarAndPrintProgress(final Car car) {
        car.moveOrStop();
        OutputView.printRacingProgress(car);
    }
}
