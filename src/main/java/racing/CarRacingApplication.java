package racing;

import racing.view.InputView;
import racing.view.OutputView;

public class CarRacingApplication {

    public static void main(String[] args) {
        int numberOfCar = InputView.inputCarCount();
        int numberOfTry = InputView.inputTryCount();

        OutputView.output(numberOfCar);

        Cars cars = new Cars(numberOfCar);
        for (int i = 0; i < numberOfTry; i++) {
            cars.move();
            OutputView.outputProgress(cars);
        }
    }

}
