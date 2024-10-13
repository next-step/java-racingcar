package racingcar;


import racingcar.domain.Car;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RaceGame;
import racingcar.domain.RandomMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class GameApplication {

    public static void main(String[] args) {
        List<Car> cars = InputView.getCarNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());

        int tryCount = InputView.getTryCount();

        RaceGame raceGame = new RaceGame(cars);
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        ResultView.printExecuteMessage();
        for (int i = 0; i < tryCount; i++) {
            raceGame.moveCars(moveStrategy);
            ResultView.print(raceGame);
        }
        ResultView.printWinnersName(raceGame);
    }
}
