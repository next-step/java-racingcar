/*
 * Car.java  1.0.0   2019.10.27
 */
package step2.racing;


import step2.move.MoveStrategy;

import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 자동차 게임의 대상인 자동차
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class Car {
    private static final int START_INDEX = 0;
    private static final int EXTRA_INDEX_FOR_OPEN_RANGE = 1;

    private String model;
    private BitSet moveSet;

    public Car(String model, int turn) {
        this.model = model;
        this.moveSet = new BitSet(turn);
    }

    public static Map<String, Integer> scoreByTurn(List<Car> cars, int turn) {
        Map<String, Integer> carScores = new HashMap<>();
        cars.forEach(car -> {
            carScores.put(car.model, car.getScoreByTurn(turn));
        });
        return carScores;
    }

    public int getFinalScore() {
        return moveSet.cardinality();
    }

    private boolean isWinner(int max) {
        return getFinalScore() == max;
    }

    public void addWinner(List<String> winners, int max) {
        if (isWinner(max)) {
            winners.add(model);
        }
    }

    public void move(MoveStrategy moveStrategy, int turn) {
        if (moveStrategy.isPossibleToGo()) {
            moveSet.set(turn);
        }
    }

    public int getScoreByTurn(int turn) {
        return moveSet.get(START_INDEX, turn + EXTRA_INDEX_FOR_OPEN_RANGE)
                .cardinality();
    }
}