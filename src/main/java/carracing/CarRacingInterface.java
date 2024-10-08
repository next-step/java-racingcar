package carracing;

import carracing.domain.carracing.CarRacing;
import carracing.view.InputView;

public class CarRacingInterface {
    public static void start() {
        String[] carNames = InputView.carNamesFromUser();
        int moveTryCount = InputView.moveTryCountFromUser();
        CarRacing carRacing = new CarRacing(carNames, moveTryCount);

        carRacing.start();
    }

    public static void main(String[] args) {
        CarRacingInterface.start();
    }
}
