package basicgame;

public class Counter {

    private int value;

    public Counter(int count) {
        this.value = count;
    }

    public int getValue() {
        return value;
    }

    public void autoIncrement() {
        value++;
    }
}
