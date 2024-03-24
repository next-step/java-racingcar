package racing;

import exception.CarLocationException;
import ui.InputView;

public class RacingApplication {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        Count tryCount = Count.getInstance(InputView.getTryCount());
        try {
            RacingService.race(carNames, tryCount);
        } catch (CarLocationException e) {
            throw new RuntimeException(e);
        }
    }

}
