/*
 * Racing.java  1.0.0   2019.10.27
 */
package step2.racing;

import step2.dto.RacingData;
import step2.dto.ResultData;
import step2.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 게임 진행 부분
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class Racing {
    private List<Car> cars;
    private int turn;
    private MoveStrategy moveStrategy;

    public Racing(RacingData racingData, MoveStrategy moveStrategy) {
        this.turn = racingData.getTurn();
        this.cars = new ArrayList<>();
        String[] carModels = racingData.getCarModels();
        for (String model : carModels) {
            Car car = new Car(model, turn);
            cars.add(car);
        }
        this.moveStrategy = moveStrategy;
    }

    public ResultData race() {
        for (int game = 0; game < turn; game++) {
            raceRound(game);
        }
        return new ResultData(this.cars);
    }

    private void raceRound(int turn) {
        for (Car car : this.cars) {
            moveIfPossible(car, this.moveStrategy, turn);
        }
    }

    private void moveIfPossible(Car car, MoveStrategy moveStrategy, int turn) {
        if (moveStrategy.isPossibleToGo()) {
            car.move(turn);
        }
    }
}