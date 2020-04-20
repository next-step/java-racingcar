package racinggame.controller;

import racinggame.domain.MoveStrategy;
import racinggame.domain.RacingGame;
import racinggame.domain.RandomBasedMoveStrategy;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.List;

public class RacingGameApp {

    public static void main(String[] args) {

        List<String> carNames = InputView.cars();
        int roundNumber = InputView.rounds();

        MoveStrategy moveStrategy = new RandomBasedMoveStrategy();
        RacingGame racingGame = new RacingGame(carNames, roundNumber);

        ResultView.printRacingResult(racingGame.allRounds(moveStrategy), racingGame.findWinners());
    }
}
