package step3;

import step3.domain.CarRacing;
import step3.view.InputView;

public class CarRacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.getCarNames();

        int numOfTries = inputView.getNumOfTries();
        if (numOfTries < 1) throw new RuntimeException("시도 횟수는 1 이상만 허용됩니다. ( 입력값 : " + numOfTries + " )");

        CarRacing carRacing = new CarRacing(carNames, numOfTries);
        carRacing.start();
    }

}
