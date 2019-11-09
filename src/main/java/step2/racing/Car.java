/*
 * Car.java  1.0.0   2019.10.27
 */
package step2.racing;


import step2.move.MoveStrategy;

import java.util.BitSet;
import java.util.List;

/**
 * 자동차 게임의 대상인 자동차
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class Car {

    private String model;
    private BitSet moveSet;

    public Car(String model, int turn) {
        this.model = model;
        this.moveSet = new BitSet(turn);
    }

    public int getScoreByTurn(int turn) {
        return moveSet.get(0, turn + 1).cardinality();
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
}