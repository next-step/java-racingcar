package basicgame;

public class Count {

    private int value;

    public Count(int count) {
        this.value = count;
    }

    public int getValue() {
        return value;
    }

    public void autoIncrement() {
        value++;
    }
}
