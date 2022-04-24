package racingcarwinner;

import racingcarwinner.domain.ParticipatedCars;
import racingcarwinner.domain.TryCount;
import racingcarwinner.factory.ObjectFactory;
import racingcarwinner.service.ParticipatedCarsUtils;
import racingcarwinner.service.RacingCarGameUtils;
import racingcarwinner.view.InputView;

public class RacingCarGame {

    public static void main(String[] args) {

        ObjectFactory factory = new ObjectFactory();

        ParticipatedCars participatedCars = factory.createParticipatedCars();

        TryCount tryCount = factory.createTryCount();

        RacingCarGameUtils racingCarGameUtils = factory.createRacingCarGameUtils(tryCount);

        racingCarGameUtils.play(participatedCars);

    }
}
