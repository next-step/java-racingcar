/*
 * Racing.java  1.0.0   2019.10.27
 */
package step2.Model;

import step2.Dao.RacingData;
import step2.Dao.ResultData;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 게임 진행 부분
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class Racing {
    private List<Car> carList;
    private int turn;
    private MoveStrategy moveStrategy;


    public Racing(RacingData racingData, MoveStrategy moveStrategy) {
        this.turn = racingData.getTurn();
        this.carList = new ArrayList<>();
        String[] carsName = racingData.getCarsName();
        for (String s : carsName) {
            Car car = new Car(s, turn);
            carList.add(car);
        }
        this.moveStrategy = moveStrategy;
    }

    public ResultData run() {
        List<Graph> carResults = Graph.createList(carList);
        for (int race = 0; race < turn; race++) {
            race(carResults, race);
        }
        return new ResultData(carResults);
    }

    private void race(List<Graph> carResults, int turn) {
        for (int carIndex = 0; carIndex < carList.size(); carIndex++) {
            carResults.get(carIndex).addGraph(move(carIndex, turn));
        }
    }

    public String move(int carIndex, int turn) {
        if (moveStrategy.isPossibleToGo()) {
            return carList.get(carIndex).go(turn);
        }
        return carList.get(carIndex).getStringScore(turn);
    }

}