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
    BitSet moveCountSet = new BitSet();

    Car(int turn) {
        moveCountSet.set(turn);
    }

    public void go(int turn) {
        if (isPossibleToGo()) {
            ahead(turn);
        }
    }

    void ahead(int turn) {
        moveCountSet.set(turn);
    }

    private boolean isPossibleToGo() {
        int random = (int) (Math.random() * 10);
        return random >= 4;
    }

}
