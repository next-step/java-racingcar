package racingcar.controller;

import static racingcar.view.InputView.scanAndGetValues;

import racingcar.common.utils.TextManipulator;
import racingcar.model.RacingCarGame;
import racingcar.model.movestrategy.RandomMoveStrategy;
import racingcar.view.ResultView;
import racingcar.view.dto.RacingGameInput;

public class RacingCarGameMain {

        public static void main(String args[]) {
                RacingGameInput inputValue = scanAndGetValues();
                String carNamesInOneText = inputValue.getCarNamesInOneText();
                int round = inputValue.getRound();
                String[] carNames = TextManipulator.splitTextByComma(carNamesInOneText);

                RacingCarGame game = new RacingCarGame(round, new RandomMoveStrategy(), carNames);
                while (game.isOngoing()) {
                        game.moveOneRound();
                        ResultView.printPositionForAllCarsInCurrentRound(game.cars().values());
                }

                ResultView.printResultViewTitle();
                ResultView.printPositionForAllCarsInCurrentRound(game.cars().values());
                ResultView.printWinner(game.cars().findWinners());
        }
}
