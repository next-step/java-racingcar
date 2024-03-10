package racing;

public class Car {

    private static final int MAX_VALUE = 4;
    private int level;

    public int run(int value) {
        if (canRun(value))
            level++;
        return level;
    }

    public boolean canRun(int value) {
        return value <= MAX_VALUE;
    }
}
