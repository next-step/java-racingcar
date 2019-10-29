/*
 * Car.java  1.0.0   2019.10.27
 */
package step2;


/**
 * 자동차 게임의 대상인 자동차
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class Car {
    private String name;
    private boolean[] move;

    public Car(String name, int turn) {
        this.name = name;
        move = new boolean[turn];
    }

    public void go(int turn) {
        move[turn - 1] = true;
    }

    public String getName() {
        return name;
    }

    public boolean getMoveOfTurn(int turn) {
        return move[turn - 1];
    }
}