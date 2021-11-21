package carracing;

import carracing.controller.CarRacing;
import carracing.exception.CarNameFormatException;
import carracing.view.InputInfo;
import carracing.view.InputView;

public class Main {

    public static void main(String[] args) throws CarNameFormatException {

        InputView inputView = new InputView();
        inputView.carNameQuestion();
        inputView.tryCountQuestion();

        CarRacing carRacing = new CarRacing();
        carRacing.racingStart(new InputInfo(inputView.getCarNames(), inputView.getTryCount()));
    }
}
