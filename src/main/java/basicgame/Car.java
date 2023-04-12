package basicgame;

public class Car {
    private final StringBuffer distance;
    private final static int CONDITION_VALUE = 4;

    private final static String PROCESS_INDICATOR = "-";

    public Car(StringBuffer distance) {
        this.distance = distance;
    }

    public void go(int value) {
        if (isEnoughValue(value)) {
            distance.append(PROCESS_INDICATOR);
        }
    }

    public boolean isEnoughValue(int value) {
        return CONDITION_VALUE <= value;
    }

    @Override
    public String toString() {
        return distance.toString();
    }
}
