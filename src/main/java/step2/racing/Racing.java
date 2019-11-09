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

    public ResultData run() {
        for (int game = 0; game < turn; game++) {
            for (int carIndex = 0; carIndex < this.cars.size(); carIndex++) {
                Car car = this.cars.get(carIndex);
                car.move(moveStrategy, game);
            }
        }
        return new ResultData(cars);
    }

}