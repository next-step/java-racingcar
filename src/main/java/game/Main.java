package game;

import game.domain.game.RacingGame;
import game.domain.car.RacingGameCarList;
import game.domain.rule.RacingGameRule;
import game.view.input.RacingGameInput;

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
