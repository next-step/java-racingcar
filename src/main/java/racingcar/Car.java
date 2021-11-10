package racingcar;

import common.View;

public class Car extends View {

    private int state;

    public Car() {
        this.state = 0;
    }

    public void increaseState(int random) {
        if (random >= 4) {
            this.state++;
        }
    }

    @Override
    public void print() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.state; i++) {
            result.append("-");
        }
        System.out.println(result);
    }

    public int getState() {
        return state;
    }
}
