package racing;

import racing.entity.RacingGame;

public class RacingGameApplication {
    public static void main(String[] args) {
        RacingGame racingGame = RacingGame.readyRacingGame();
        racingGame.playRacingGame();
    }
}