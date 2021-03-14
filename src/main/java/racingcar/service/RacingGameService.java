package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.GameStep;
import racingcar.view.InputView;

public class RacingGameService implements GameService<Cars> {
    private Cars cars;
    private GameStep gameStep;

    @Override
    public void initGame() {
        gameStep = new GameStep();
        cars = new Cars(InputView.getCarNumber());
    }

    @Override
    public void runStep() {
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        for (int i = 0; i < cars.getCarsSize(); i++) {
            cars.moveOneCar(i, moveStrategy.getIsMove());
        }
        gameStep.increaseStep();
    }

    @Override
    public Boolean isRunning() {
        return gameStep.isRunning();
    }

    @Override
    public Cars getGameInstance() {
        return cars;
    }
}
