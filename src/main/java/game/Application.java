package game;

import game.ui.ConsoleRacingGameInputView;
import game.ui.ConsoleRacingGameResultView;
import game.ui.RacingGameInputView;
import game.ui.RacingGameResultView;

import java.util.Random;

public class Application {

    public static void main(String[] args) {
        MovePolicy movePolicy = new RandomMovePolicy(new Random());
        RacingGameInputView racingGameInputView = new ConsoleRacingGameInputView();
        RacingGameResultView racingGameResultView = new ConsoleRacingGameResultView();
        RacingGame racingGame = new RacingGame(movePolicy, racingGameInputView, racingGameResultView);

        racingGame.play();
    }
}
