package racingcar;


import racingcar.domain.*;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class GameApplication {

    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        Cars cars= Cars.createCars(carNames);

        int tryCount = InputView.getTryCount();

        MoveStrategy moveStrategy = new RandomMoveStrategy();

        ResultView.printExecuteMessage();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars(moveStrategy);
            ResultView.print(cars);
        }
        ResultView.printWinnersName(cars);
    }
}
