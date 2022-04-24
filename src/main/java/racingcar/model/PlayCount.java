package racingcar.model;

public class PlayCount {
    private int value = 0;

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
