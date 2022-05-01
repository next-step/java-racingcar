package racingcarwinnerrefactor;

import racingcarwinnerrefactor.domain.ParticipatedCars;
import racingcarwinnerrefactor.domain.TryCount;
import racingcarwinnerrefactor.util.GameUtil;
import racingcarwinnerrefactor.util.ObjectFactory;

public class RacingCarGame {

    public static void main(String[] args) {
        ObjectFactory.createParticipatedCars();
        ObjectFactory.createTryCount();
        GameUtil gameUtil = ObjectFactory.createGameUtil();

        gameUtil.play();
    }
}
