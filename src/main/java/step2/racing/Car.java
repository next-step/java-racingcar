/*
 * Car.java  1.0.0   2019.10.27
 */
package step2.racing;

import java.util.BitSet;

/**
 * 자동차 게임의 대상인 자동차
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class Car {
    private static final int START_INDEX = 0;
    private static final int EXTRA_INDEX_FOR_OPEN_RANGE = 1;

    private Model model;
    private BitSet moveRecord;

    public Car(String model, int round) {
        this.model = new Model(model);
        this.moveRecord = new BitSet(round);
    }

    public int checkFinalScore() {
        return moveRecord.cardinality();
    }

    public void move(int round) {
        moveRecord.set(round);
    }

    public int checkScoreByRound(int round) {
        return moveRecord.get(START_INDEX, round + EXTRA_INDEX_FOR_OPEN_RANGE)
                .cardinality();
    }

    public Model getModel() {
        return this.model;
    }
}