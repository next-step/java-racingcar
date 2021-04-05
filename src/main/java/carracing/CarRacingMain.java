package carracing;

import carracing.service.CarRacing;
import carracing.view.InputView;


public class CarRacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        CarRacing carRacing = new CarRacing();

        String carNames = inputView.inputCarName();
        int tryCount = inputView.inputTryCount();

        carRacing.ready(carNames, tryCount);
        carRacing.start();
    }
}
