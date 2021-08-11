package racingcargame;

public class Distance {
    private int value = 0;

    public Distance(int value) {
        this.value = value;
    }

    public int increase() {
        return value += 1;
    }

    public int getValue() {
        return value;
    }
}
