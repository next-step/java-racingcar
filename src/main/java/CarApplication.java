import race.controller.RacingGame;
import race.strategy.RandomMoveStrategy;

public class CarApplication {

    public static void main(String[] args) {
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        RacingGame racingGame = new RacingGame();
        racingGame.play(randomMoveStrategy);
    }
}
