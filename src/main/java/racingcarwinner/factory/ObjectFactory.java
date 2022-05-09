package racingcarwinner.factory;

import racingcarwinner.domain.Car;
import racingcarwinner.domain.ParticipatedCars;
import racingcarwinner.domain.TryCount;
import racingcarwinner.domain.WinnerCars;
import racingcarwinner.service.ParticipatedCarsUtils;
import racingcarwinner.service.RacingCarGameUtils;
import racingcarwinner.view.InputView;

public class ObjectFactory {

    public static ParticipatedCars createParticipatedCars() {
        String carNames = InputView.getCarNamesInput();
        return new ParticipatedCars(ParticipatedCarsUtils.splitCarNames(carNames));
    }

    public static TryCount createTryCount() {
        int number = InputView.getTryCountInput();
        return new TryCount(number);
    }

    public static RacingCarGameUtils createRacingCarGameUtils(TryCount tryCount) {
        return new RacingCarGameUtils(tryCount);
    }
}
