package racingCar.game;

import racingCar.car.Cars;
import racingCar.car.Winners;
import racingCar.ui.InputView;
import racingCar.ui.ResultView;

public class RacingCarGame { // 자동차 경주를 수행한다.
    private final InputView inputView;
    private final ResultView resultView;
    private GameRequest gameRequest;
    private Cars cars;

    public RacingCarGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        gameRequest = inputView.gameRequest();

        resultView.printPrefix();

        cars = Cars.of(gameRequest.carNameList());

        moveByTryCount();
        Winners winners = new Winners(cars);
        resultView.printWinner(winners);
    }

    private void moveByTryCount() {
        for (int i = 0; i < gameRequest.tryCount(); i++) {
            cars.moveOnce();
            resultView.printDistanceWithName(cars);
        }
    }
}
