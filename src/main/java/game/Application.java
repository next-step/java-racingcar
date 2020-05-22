package game;

import game.domain.MovePolicy;
import game.domain.RacingGame;
import game.domain.RandomMovePolicy;
import game.view.ConsoleRacingGameInputView;
import game.view.ConsoleRacingGameResultView;
import game.view.RacingGameInputView;
import game.view.RacingGameResultView;

public class Application {

    public static void main(String[] args) {
        MovePolicy movePolicy = new RandomMovePolicy();
        RacingGameInputView racingGameInputView = new ConsoleRacingGameInputView();
        RacingGameResultView racingGameResultView = new ConsoleRacingGameResultView();
        RacingGame racingGame = new RacingGame(movePolicy, racingGameInputView, racingGameResultView);

        racingGame.play();
    }
}
