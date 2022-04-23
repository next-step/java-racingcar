package racingcarwinner;

import racingcarwinner.domain.CarCount;
import racingcarwinner.domain.ParticipatedCars;
import racingcarwinner.domain.TryCount;
import racingcarwinner.service.ParticipatedCarsUtils;
import racingcarwinner.service.RacingCarGameUtils;
import racingcarwinner.view.InputView;

public class RacingCarGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String carNames = inputView.getCarNamesInput();
        String[] carNamesArray = new ParticipatedCarsUtils(carNames).getCarNames();
        CarCount carCount = new CarCount(carNamesArray);

        ParticipatedCars participatedCars = new ParticipatedCars(carNamesArray);

        int tryCountInput = inputView.getTryCountInput();
        TryCount tryCount = new TryCount(tryCountInput);

        RacingCarGameUtils racingCarGameUtils = new RacingCarGameUtils(carCount, tryCount);
        racingCarGameUtils.play(participatedCars);

    }
}
