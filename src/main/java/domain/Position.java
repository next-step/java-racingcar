package domain;

public class Position {
    private int value;

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void increase() {
        this.value++;
    }
}
