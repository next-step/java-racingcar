package step3;

import java.util.List;

public class CarRacingController {

    public static void main(String[] args) {
        String carNameString = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        CarRacing carRacing = new CarRacing(carNameString);

        ResultView.printResultStart();

        List<Car> cars = carRacing.getCars();

        for (int i = 0; i < tryCount; i++) {
            ResultView.printResult(carRacing.racing(cars));
        }

        ResultView.printWinner(carRacing.extractWinner(cars));
    }
}
