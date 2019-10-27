/*
* Car.java  1.0.0   2019.10.27
*/
package step2;


import java.util.BitSet;

/**
 * 자동차 게임의 대상인 자동차
 * @version 1.0.0
 * @author naheenosaur
 */
public class Car {
    BitSet moveCountSet;

    Car(int turn) {
        moveCountSet = new BitSet(turn);
    }

    public void go(int turn) {
        if (isPossibleToGo()) {
            ahead(turn);
        }
    }

    void ahead(int turn) {
        moveCountSet.set(turn - 1);
    }

    private boolean isPossibleToGo() {
        int random = (int) (Math.random() * 10);
        return random >= 4;
    }

    public int getScore(int turn) {
        int score = moveCountSet.get(0,turn).cardinality();
        if (score < 0) {
            return 0;
        }
        return score;
    }

}
