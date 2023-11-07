package racing;

import racing.view.InputView;

public class RacingApplication {
    public static void main(String[] args){
        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        Racing racing = new Racing(carCount);
        racing.race(tryCount);
    }
}
