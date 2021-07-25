package racingcar.domain;

public class Distance {

    private int value;

    private Distance() {

    }

    public static Distance from() {
        return new Distance();
    }

    public void move(boolean isMove) {
        if (isMove) {
            value++;
        }
    }

    public int getValue() {
        return value;
    }


}
