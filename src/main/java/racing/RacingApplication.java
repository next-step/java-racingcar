package racing;

import exception.CarLocationException;
import ui.InputView;

public class RacingApplication {

    public static void main(String[] args) {
        Count carCount = Count.getInstance(InputView.getCarCount());
        Count tryCount = Count.getInstance(InputView.getTryCount());
        try {
            RacingService.race(carCount, tryCount);
        } catch (CarLocationException e) {
            throw new RuntimeException(e);
        }
    }

}
