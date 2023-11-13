package racingCar;

import racingCar.ui.InputView;
import racingCar.ui.ResultView;

public class RacingCarGame { // 자동차 경주를 수행한다.
    private final InputView inputView = new InputView();
    private GameRequest gameRequest;
    private Cars cars;

    public void run() {
        gameRequest = inputView.gameRequest();

        ResultView.printPrefix();

        cars = Cars.of(gameRequest.carCount());

        moveByTryCount();
    }

    private void moveByTryCount() {
        for (int i = 0; i < gameRequest.tryCount(); i++) {
            cars.moveOnce();
            ResultView.printDistance(cars);
        }
    }
}
