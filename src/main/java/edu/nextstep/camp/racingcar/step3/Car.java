package edu.nextstep.camp.racingcar.step3;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final String MOVE_SYMBOL = "-";

    private int position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = position;
    }

    public void move(int number) {
        if (number >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getPositionString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(MOVE_SYMBOL);
        }
        return sb.toString();
    }
}
