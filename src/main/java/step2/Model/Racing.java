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
            carResults = race(carResults, race);
        }
        return new ResultData(carResults);
    }

    public List<Graph> race(List<Graph> carResults, int turn) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            move(car, turn);
            carResults.get(i).addGraph(car.getStringScore(turn));
        }
        return carResults;
    }

    public void move(Car car, int turn) {
        if (moveStrategy.isPossibleToGo()) {
            car.go(turn);
        }
    }
}