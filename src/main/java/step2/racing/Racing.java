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
        List<Graph> graphs = Graph.createList(cars);
        for (int game = 0; game < turn; game++) {
            race(graphs, game);
        }
        return new ResultData(graphs);
    }

    private void race(List<Graph> graphs, int turn) {
        for (int carIndex = 0; carIndex < cars.size(); carIndex++) {
            Graph graph = graphs.get(carIndex);
            graph.addScore(scoreAfterMove(carIndex, turn));
        }
    }

    public String scoreAfterMove(int carIndex, int turn) {
        if (moveStrategy.isPossibleToGo()) {
            return cars.get(carIndex).go(turn);
        }
        return cars.get(carIndex).getStringScore(turn);
    }

}