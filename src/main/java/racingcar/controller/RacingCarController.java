package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.model.movestrategy.MoveStrategy;
import racingcar.model.movestrategy.RandomVarMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarController {
    public static void main(String[] args) {
        // input
        List<String> carNameList = InputView.inputCarNameList();
        int roundNumber = InputView.inputRoundNumber();

        // control
        RacingGame racingGame = new RacingGame(carNameList, roundNumber);
        ResultView.startPrint();
        for (int round = 1; round <= roundNumber; round++) {
            racingGame.playOneRound(new RandomVarMoveStrategy());
            ResultView.printRoundResult(racingGame);
        }

        // output
        ResultView.printWinners(racingGame.winners());
    }
}
