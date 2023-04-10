package racingcar;

import racingcar.strategy.DefaultRandomStrategy;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.PositionPrintStrategy;
import racingcar.strategy.PrintStrategy;
import racingcar.strategy.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameController {
    public static void main(String[] args) {
        String[] carNames = getCarNames();
        int numberOfTries = InputView.getNumberOfTries();

        RacingCarGame racingCarGame = setUpGame(carNames);

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfTries; i++) {
            racingCarGame.play();
            racingCarGame.printPosition();
        }

        racingCarGame.printWinners();
    }

    private static RacingCarGame setUpGame(String[] carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        MoveStrategy moveStrategy = new RandomMoveStrategy(new DefaultRandomStrategy(), 4);
        for (int i = 0; i < carNames.length; i++) {
            racingCars.add(new RacingCar(carNames[i], moveStrategy));
        }
        PrintStrategy printStrategy = new PositionPrintStrategy();
        RacingCarGame racingCarGame = new RacingCarGame(racingCars, printStrategy);
        return racingCarGame;
    }

    private static String[] getCarNames() {
        String carNamesString = InputView.getCarNames();
        String[] carNames = carNamesString.split(",");
        return carNames;
    }
}
