/*
 * Car.java  1.0.0   2019.10.27
 */
package step2;


import java.util.BitSet;

/**
 * 자동차 게임의 대상인 자동차
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class Car {
    private BitSet moveCountSet;

    public Car(int turn) {
        moveCountSet = new BitSet(turn);
    }

    public void go(int turn) {
        moveCountSet.set(turn - 1);
    }

    public boolean getMove(int turn) {
        return moveCountSet.get(turn - 1);
    }

    public int getScore(int turn) {
        int score = moveCountSet.get(0, turn).cardinality();
        if (score < 0) {
            return 0;
        }
        return score;
    }

}
