package step4.controller;

import step4.view.ResultView;
import step4.domain.Cars;
import step4.vo.GameRequestVO;

public class GameController {
    private final Cars cars;
    private int roundCount;

    public GameController(final GameRequestVO gameRequestVO) {
        this.cars = Cars.from(gameRequestVO.getCarNames());
        this.roundCount = gameRequestVO.getRoundCount();
    }

    public void run() {
        ResultView.printResultStartMessage();
        while (isMovable()) {
            cars.move();
            ResultView.printPosition(cars);
        }
    }

    private boolean isMovable() {
        roundCount--;
        return roundCount >= 0;
    }
}
