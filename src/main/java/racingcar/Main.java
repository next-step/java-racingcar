package racingcar;

import racingcar.domain.*;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] carNameStrings = InputView.promptCarNames();
        List<CarName> carNames = CarName.createCarNames(carNameStrings);
        Cars cars = new Cars(CarFactory.generateCars(carNames));
        int rounds = InputView.promptRounds();
        RacingCarGame game = new RacingCarGame(cars, rounds, new RandomMoveStrategy());

        OutputView.printRaceStart();

        for (int i = 0; i < rounds; i++) {
            game.proceedRound();
            OutputView.printCurrentPositions(cars);
        }

        List<String> winCarNames = cars.getMostDistantCarNames();
        OutputView.printWinCarNames(winCarNames);
    }

}
