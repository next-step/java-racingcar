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
    private int round;
    private MoveStrategy moveStrategy;

    public Racing(RacingData racingData, MoveStrategy moveStrategy) {
        this.round = racingData.getRound();
        this.cars = new ArrayList<>();
        String[] carModels = racingData.getCarModels();
        for (String model : carModels) {
            Car car = new Car(model, round);
            cars.add(car);
        }
        this.moveStrategy = moveStrategy;
    }

    public ResultData race() {
        for (int game = 0; game < round; game++) {
            raceRound(game);
        }
        return new ResultData(this.cars);
    }

    private void raceRound(int round) {
        for (Car car : this.cars) {
            moveIfPossible(car, this.moveStrategy, round);
        }
    }

    private void moveIfPossible(Car car, MoveStrategy moveStrategy, int round) {
        if (moveStrategy.isPossibleToGo()) {
            car.move(round);
        }
    }
}