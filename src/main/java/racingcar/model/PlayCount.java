package racingcar.model;

public class PlayCount {
    private final int value;

    public PlayCount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isLast(int index) {
        return index == getValue();
    }
}