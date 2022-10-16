package racingGame;
import racingGame.domain.Car;
import racingGame.strategy.MoveStrategy;
import racingGame.strategy.NumberGenerateStrategy;
import racingGame.domain.Cars;

import static racingGame.view.InputView.carCount;
import static racingGame.view.InputView.tryCount;
import static racingGame.view.ResultView.racingResult;
import static racingGame.view.ResultView.resultMessage;

public class RacingGame {

    private final MoveStrategy moveStrategy;
    private final NumberGenerateStrategy numberGenerateStrategy;
    private Cars cars;

    public RacingGame(MoveStrategy moveStrategy, NumberGenerateStrategy numberGenerateStrategy, int carCount){
        this.moveStrategy = moveStrategy;
        this.numberGenerateStrategy = numberGenerateStrategy;
        this.cars = Cars.makeCars(carCount);
    }

    public void race(int tryCount){
        resultMessage();
        for(int i= 0; i < tryCount; i++){
            cars.carTryMove(moveStrategy,numberGenerateStrategy);
            racingResult(cars);
        }
    }
}