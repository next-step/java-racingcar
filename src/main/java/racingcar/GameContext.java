package racingcar;

import racingcar.logic.GameLogic;
import racingcar.view.input.InputView;
import racingcar.view.result.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameContext {

    private final InputView inputView;
    private final ResultView resultView;
    private final GameLogic gameLogic;

    GameContext(InputView inputView, ResultView resultView, GameLogic gameLogic) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.gameLogic = gameLogic;
    }

    public void run() {
        int numberOfCars = inputView.getNumberOfCars();
        int numberOfTimes = inputView.getNumberOfTimes();

        List<Integer> carPositions = IntStream.range(0, numberOfCars)
                .mapToObj(i -> 0)
                .collect(Collectors.toList());

        resultView.printHeader();
        for (int i=0; i<numberOfTimes; i++) {
            carPositions = gameLogic.move(carPositions);
            resultView.printBody(carPositions);
        }
        resultView.printFooter();
    }
}
