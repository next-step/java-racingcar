package step5.domain;

public class MoveCount {
    private int value;

    public MoveCount() {
    }

    public MoveCount(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public void increase() {
        this.value++;
    }
}
