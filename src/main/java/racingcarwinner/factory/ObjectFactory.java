package racingcarwinner.factory;

import racingcarwinner.domain.Car;
import racingcarwinner.domain.ParticipatedCars;
import racingcarwinner.domain.TryCount;
import racingcarwinner.domain.WinnerCars;
import racingcarwinner.service.ParticipatedCarsUtils;
import racingcarwinner.service.RacingCarGameUtils;
import racingcarwinner.view.InputView;

public class ObjectFactory {
    public Car createCar(String name) {
        return new Car(name);
    }

    public ParticipatedCars createParticipatedCars() {
        String carNames = InputView.getCarNamesInput();
        return new ParticipatedCars(ParticipatedCarsUtils.splitCarNames(carNames));
    }

    public TryCount createTryCount() {
        int number = InputView.getTryCountInput();
        return new TryCount(number);
    }

    public RacingCarGameUtils createRacingCarGameUtils(TryCount tryCount) {
        return new RacingCarGameUtils(tryCount);
    }
}
