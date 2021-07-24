package racingcar.domain;

public class Distance {

    private int value;

    private Distance() {

    }

    public static Distance from() {
        return new Distance();
    }

    public void move(int number) {
        if (isRange(number)) {
            this.value++;
        }
    }

    public int getValue() {
        return value;
    }

    private boolean isRange(final int random) {
        return random >= 4 && random < 10;
    }
}
