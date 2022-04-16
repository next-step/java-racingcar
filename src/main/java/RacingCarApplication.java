import racingcar.controller.RacingGame;
import racingcar.model.RandomMovingStrategy;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.startRacingGame(new RandomMovingStrategy());
    }
}
