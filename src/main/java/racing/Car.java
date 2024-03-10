package racing;

public class Car {

    private int level = 0;

    public int run(int value) {
        if (canRun(value))
            level++;
        return level;
    }

    public boolean canRun(int value) {
        return value <= 4;
    }
}
