package racingcar.domain;


public class Car {

    private static final int UPPER_LIMIT = 4;
    private int state;

    public Car() {
        this.state = 0;
    }

    public void increaseState(int random) {
        if (random >= UPPER_LIMIT) {
            this.state++;
        }
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.state; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public int getState() {
        return state;
    }
}
