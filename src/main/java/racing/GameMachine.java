package racing;

import racing.domain.RacingGame;
import racing.domain.RandomRoulette;

public class GameMachine {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new RandomRoulette());
        racingGame.start();
    }
}
