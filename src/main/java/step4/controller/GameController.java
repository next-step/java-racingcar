package step4.controller;

import step4.domain.Count;
import step4.strategy.MovableStrategy;
import step4.strategy.RandomNumberMovableStrategy;
import step4.view.InputView;
import step4.view.ResultView;
import step4.domain.Cars;
import step4.vo.GameRequestVO;

public class GameController {
    private final Cars cars;
    private final Count count;
    private MovableStrategy strategy;

    public GameController() {
        GameRequestVO requestVO = InputView.inputGameInfo();
        this.cars = Cars.from(requestVO.getCarNames());
        this.count = Count.from(requestVO.getRoundCount());
        this.strategy = new RandomNumberMovableStrategy();
    }

    public void run() {
        ResultView.printResultStartMessage();
        while (count.isMovable()) {
            cars.move(strategy);
            ResultView.printPosition(cars);
            count.minus();
        }
        ResultView.printWinners(cars);
    }
}
