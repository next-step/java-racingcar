package racingcar.domain;

public class Position {
    private int value;

    public Position(int value) {
        this.value = value;
    }

    public void add() {
        value ++;
    }

    public int max(int inputMax) {
        if (this.value > inputMax) {
            return this.value;
        }
        return inputMax;
    }

    public boolean isSamePosition(int inputPosition) {
        if (this.value == inputPosition) {
            return true;
        }
        return false;
    }

    public int getValue() {
        return value;
    }
}
