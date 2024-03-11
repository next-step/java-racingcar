package racing;

public class Car {

    private static final int MAX_VALUE = 4;
    private static final String LOCATION_TOKEN = "-";

    private int level;

    public String run(int value) {
        if (canRun(value))
            level++;
        return convertText(level);
    }

    public boolean canRun(int value) {
        return value <= MAX_VALUE;
    }

    private String convertText(int level) {
        return LOCATION_TOKEN.repeat(level);
    }
}
