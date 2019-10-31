/*
 * Racing.java  1.0.0   2019.10.27
 */
package step2;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 게임 진행 부분
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class Racing {

    private int turn;
    private MoveStrategy moveStrategy;
    public List<Car> carList = new ArrayList<>();
    public List<Graph> carGraph = new ArrayList<>();


    public Racing(String[] carsName, int turn) {
        this(carsName, turn, new DefaultMove());
    }

    public Racing(String[] carsName, int turn, MoveStrategy moveStrategy) {
        int length = carsName.length;
        this.turn = turn;
        for (int i = 0; i < length; i++) {
            Car car = new Car(carsName[i], turn);
            carList.add(car);
            carGraph.add(new Graph(car));
        }
        this.moveStrategy = moveStrategy;
    }

    public int getTurn() {
        return turn;
    }

    public Car getCar(int index) {
        return carList.get(index);
    }

    public List<Graph> run() {
        for (int race = 0; race < turn; race++) {
            race(race);
        }
        return carGraph;
    }

    public void race(int turn) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            move(car, turn);
            carGraph.get(i).setGraph(car.getScore(turn));
        }
    }

    public void move(Car car, int turn) {
        if (moveStrategy.isPossibleToGo()) {
            car.go(turn);
        }
    }
}