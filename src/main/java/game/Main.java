package game;

import game.domain.RacingGameCarList;
import game.domain.RacingGame;
import game.domain.RacingGameRule;
import game.io.input.RacingGameInput;

public class Main {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(
                new RacingGameRule(4, 10),
                RacingGameCarList.makeRacingGameCars(RacingGameInput.inputCarNames()),
                RacingGameInput.inputNumberOfRound()
        );
        racingGame.progressGame();
    }
}
