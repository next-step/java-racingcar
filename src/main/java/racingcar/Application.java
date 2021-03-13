package racingcar;

import racingcar.contoller.RacingCarController;
import racingcar.domain.RacingGame;

public class Application {

    public static void main(String[] args) {
        new RacingCarController(new RacingGame()).startGame();
    }
}
