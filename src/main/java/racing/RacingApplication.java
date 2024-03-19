package racing;

import exception.CarLocationException;
import ui.InputView;

public class RacingApplication {

    public static void main(String[] args) {
        Count carCount = Count.carCount(InputView.getCarCount());
        Count tryCount = Count.tryCount(InputView.getTryCount());
        try {
            RacingService.race(carCount.getValue(), tryCount.getValue());
        } catch (CarLocationException e) {
            throw new RuntimeException(e);
        }
    }

}
