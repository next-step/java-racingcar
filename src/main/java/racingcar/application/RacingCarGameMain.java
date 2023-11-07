package racingcar.application;

import static racingcar.presentation.InputView.scanAndGetValues;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.SimpleRacingCarGame;
import racingcar.presentation.OutputView;
import racingcar.presentation.dto.RacingGameInput;

public class RacingCarGameMain {

        public static void main(String args[]) {
                RacingGameInput inputValue = scanAndGetValues();
                int carCount = inputValue.getCarCount();
                int round = inputValue.getRound();

                SimpleRacingCarGame game = new SimpleRacingCarGame(carCount);
                List<Car> cars = game.joinCars();

                IntStream.range(0, round).forEach(thisRound -> {
                        game.moveOneRound(cars);
                        OutputView.printPositionForAllCarsInCurrentRound(cars);
                });
        }

}
