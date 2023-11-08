package racingcar.application;

import static racingcar.presentation.InputView.scanAndGetValues;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.common.utils.TextManipulator;
import racingcar.domain.Car;
import racingcar.domain.RacingCarGame;
import racingcar.presentation.ResultView;
import racingcar.presentation.dto.RacingGameInput;

public class RacingCarGameMain {

        public static void main(String args[]) {
                RacingGameInput inputValue = scanAndGetValues();
                String carNamesInOneText = inputValue.getCarNamesInOneText();
                int round = inputValue.getRound();
                String[] carNames = TextManipulator.splitTextByComma(carNamesInOneText);

                RacingCarGame game = new RacingCarGame(carNames);
                List<Car> cars = game.joinCars();

                ResultView.printResultViewTitle();
                ResultView.printPositionForAllCarsInCurrentRound(cars);
                IntStream.range(0, round).forEach(thisRound -> {
                        game.moveOneRound(cars);
                        ResultView.printPositionForAllCarsInCurrentRound(cars);
                });
                ResultView.printWinner(game.findWinners(cars));
        }
}
