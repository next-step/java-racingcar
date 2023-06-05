import study.racingcar.controller.RacingCarGame;
import study.racingcar.strategy.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame(new RandomNumberGenerator());
        racingCarGame.run();
    }
}
