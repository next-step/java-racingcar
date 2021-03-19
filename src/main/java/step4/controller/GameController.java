package step4.controller;

import step4.domain.Round;
import step4.view.ResultView;
import step4.domain.Cars;
import step4.vo.GameRequestVO;

public class GameController {
    private final Cars cars;
    private final Round round;

    public GameController(final GameRequestVO gameRequestVO) {
        this.cars = Cars.from(gameRequestVO.getCarNames());
        this.round = Round.from(gameRequestVO.getRoundCount());
    }

    public void run() {
        ResultView.printResultStartMessage();
        while (round.isMovable()) {
            cars.move();
            ResultView.printPosition(cars);
        }
        ResultView.printWinners(cars);
    }
}
