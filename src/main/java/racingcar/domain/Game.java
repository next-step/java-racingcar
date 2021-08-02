package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Game {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private final Cars cars;
    private int tryCount;

    public Game() {
        this.cars = new Cars(inputView.askCarsName());
    }

    public void gameStart() {
        tryCount = inputView.askTryCount();
        System.out.println(resultView.RESULT);
        while (tryCount > 0) {
            resultView.printLine(cars.carMove());
            System.out.println();
            tryCount --;
        }
        resultView.printWinner(cars);
    }

}
