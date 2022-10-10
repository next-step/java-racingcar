package racingGame;
import racingGame.domain.Car;
import racingGame.strategy.MoveStrategy;
import racingGame.domain.Cars;

import static racingGame.view.InputView.carCount;

public class RacingGame {

    private MoveStrategy moveStrategy;
    private Cars cars;

    public RacingGame(MoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
        this.cars = Cars.makeCarList(carCount());
    }

    public Cars carTryMove(int count){
        for(Car car : cars.getList()) {
            carMoveCount(car, count);
        }
        return cars;
    }

    private void carMoveCount(Car car,int count) {
        for(int i = 0; i < count; i++) {
            car.move(moveStrategy);
        }
    }
}