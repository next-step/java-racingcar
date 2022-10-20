package racingGame;
import racingGame.domain.Car;
import racingGame.domain.Number;
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
    private final Cars cars;
    private final int carCount;
    private final int tryCount;

    public RacingGame(MoveStrategy moveStrategy, NumberGenerateStrategy numberGenerateStrategy){
        this.moveStrategy = moveStrategy;
        this.numberGenerateStrategy = numberGenerateStrategy;
        this.carCount = new Number(carCount()).getValue();
        this.tryCount =  new Number(tryCount()).getValue();
        this.cars = Cars.makeCars(carCount);
    }

    public void race(){
        resultMessage();
        for(int i= 0; i < tryCount; i++){
            cars.carTryMove(moveStrategy,numberGenerateStrategy);
            racingResult(cars);
        }
    }
}