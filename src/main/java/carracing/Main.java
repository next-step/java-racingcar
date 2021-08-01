package carracing;

import carracing.application.CarRacing;
import carracing.view.InputView;
import carracing.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        CarRacing carRacing = new CarRacing();
        ResultView view = carRacing.race(inputView.inputCarCount(), inputView.inputTryCount());
        view.getResult();
    }
}
