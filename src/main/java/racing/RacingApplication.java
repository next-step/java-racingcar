package racing;

import exception.CarLocationException;
import racing.domain.Count;
import racing.service.RacingService;
import racing.view.InputView;

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
