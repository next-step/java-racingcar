package basicgame;

public class CarTryCounter {

    private int value;

    public CarTryCounter(int count) {
        this.value = count;
    }

    public int getValue() {
        return value;
    }

    public void autoIncrement() {
        value++;
    }
}
