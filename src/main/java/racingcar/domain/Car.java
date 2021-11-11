package racingcar.domain;


public class Car {

    private static final int UPPER_LIMIT = 4;
    private int state;
    private String name;

    public Car() {
        this.state = 0;
    }

    public Car(String name) {
        this.state = 0;
        this.name = name;
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

    public String getName() {
        return name;
    }
}
