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
    private static final String CAR_LOG_SYMBOL = "-";
    private String model;
    private boolean[] move;

    public Car(String model, int turn) {
        this.model = model;
        this.move = new boolean[turn];
    }

    public String go(int turn) {
        move[turn] = true;
        return getStringScore(turn);
    }

    public String getStringScore(int turn) {
        StringBuilder graph = new StringBuilder();
        for (int game = 0; game <= turn; game++) {
            if (move[game]) {
                graph.append(CAR_LOG_SYMBOL);
            }
        }
        return graph.toString();
    }

    public String getModel() {
        return model;
    }

}