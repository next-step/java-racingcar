package racingcarwinner;

import racingcarwinner.domain.ParticipatedCars;
import racingcarwinner.domain.TryCount;
import racingcarwinner.factory.ObjectFactory;
import racingcarwinner.service.ParticipatedCarsUtils;
import racingcarwinner.service.RacingCarGameUtils;
import racingcarwinner.view.InputView;

public class RacingCarGame {

    public static void main(String[] args) {

        ParticipatedCars participatedCars = ObjectFactory.createParticipatedCars();

        TryCount tryCount = ObjectFactory.createTryCount();

        RacingCarGameUtils racingCarGameUtils = ObjectFactory.createRacingCarGameUtils(tryCount);

        racingCarGameUtils.play(participatedCars);

    }
}
