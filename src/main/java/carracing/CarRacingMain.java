package carracing;

import carracing.domain.Cars;
import carracing.service.CarRacing;
import carracing.view.InputView;

public class CarRacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String carNames = inputView.inputCarName();
        int tryCount = inputView.inputTryCount();

        Cars cars = new Cars(carNames);
        new CarRacing().start(cars, tryCount);
    }
}
