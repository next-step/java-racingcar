package step3;

import step3.ui.InputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numberOfCars = inputView.getNumberOfCars();
        int numberOfTry = inputView.getNumberOfTry();
    }
}
