/*
 * Car.java  1.0.0   2019.10.27
 */
package step2.Model;


/**
 * 자동차 게임의 대상인 자동차
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class Car {
    private static final String CAR_LOG_SYMBOL = "_";
    private String name;
    private boolean[] move;

    public Car(String name, int turn) {
        this.name = name;
        move = new boolean[turn];
    }

    public void go(int turn) {
        move[turn] = true;
    }

    public String getStringScore(int turn) {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i <= turn; i++) {
            if (move[i]) {
                graph.append(CAR_LOG_SYMBOL);
            }
        }
        return graph.toString();
    }

    public String getName() {
        return name;
    }

}