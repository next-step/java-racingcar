package racingcar;

import racingcar.service.RacingGame;

public class Application {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.setCarNumber();
        racingGame.setMoveTimes();
        racingGame.racing();
    }
}
