package racing;

import ui.InputView;

public class RacingApplication {

    public static void main(String[] args) {
        int carCount = InputView.getCarCount();
        int tryCount = InputView.getTryCount();
        RacingService.race(carCount, tryCount);
    }

}
