package racing;

import ui.InputView;

public class RacingApplication {

    public static void main(String[] args) {
        Count carCount = Count.carCount(InputView.getCarCount());
        Count tryCount = Count.tryCount(InputView.getTryCount());
        RacingService.race(carCount.getValue(), tryCount.getValue());
    }

}
