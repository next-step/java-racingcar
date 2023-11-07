package step3.application;

import static step3.presentation.InputView.scanAndGetValues;

import java.util.List;
import java.util.stream.IntStream;
import step3.domain.Car;
import step3.domain.SimpleRacingCarGame;
import step3.presentation.OutputView;
import step3.presentation.dto.RacingGameInput;

public class RacingCarGameMain {

        public static void main(String args[]) {
                RacingGameInput inputValue = scanAndGetValues();
                int carCnt = inputValue.getCarCnt();
                int round = inputValue.getRound();

                SimpleRacingCarGame game = new SimpleRacingCarGame(carCnt);
                List<Car> cars = game.joinCars();

                IntStream.range(0, round).forEach(thisRound -> {
                        game.moveOneRound(cars);
                        OutputView.printPositionForAllCarsInCurrentRound(cars);
                });
        }

}
