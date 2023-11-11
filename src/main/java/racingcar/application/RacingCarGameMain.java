package racingcar.application;

import static racingcar.presentation.InputView.scanAndGetValues;

import racingcar.common.utils.TextManipulator;
import racingcar.domain.RacingCarGame;
import racingcar.domain.Winners;
import racingcar.presentation.ResultView;
import racingcar.presentation.dto.RacingGameInput;

public class RacingCarGameMain {

        public static void main(String args[]) {
                RacingGameInput inputValue = scanAndGetValues();
                String carNamesInOneText = inputValue.getCarNamesInOneText();
                int round = inputValue.getRound();
                String[] carNames = TextManipulator.splitTextByComma(carNamesInOneText);

                RacingCarGame game = new RacingCarGame(round, carNames);
                while (game.isOngoing()) {
                        game.moveOneRound();
                        ResultView.printPositionForAllCarsInCurrentRound(game.cars());
                }

                ResultView.printResultViewTitle();
                ResultView.printPositionForAllCarsInCurrentRound(game.cars());
                ResultView.printWinner(Winners.findWinners(game.cars()));
        }
}
