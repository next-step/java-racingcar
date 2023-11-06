package step3.model;

public class Car {

    private static final int MIN_GO_VALUE = 4;
    private static final int MAX_GO_VALUE = 9;
    private static final int INITIAL_DISTANCE = 0;
    private static final String DISTANCE_EXPRESSION = "-";

    private int distance;

    private Car(int distance) {
        this.distance = distance;
    }

    public static Car makeCar() {
        return new Car(INITIAL_DISTANCE);
    }

    public int getDistance() {
        return distance;
    }

    public void go(int randomValue) {
        if (isGoCondition(randomValue)) {
            distance += 1;
        }
    }

    private boolean isGoCondition(int randomValue) {
        return randomValue >= MIN_GO_VALUE && randomValue <= MAX_GO_VALUE;
    }

    @Override
    public String toString() {
        return DISTANCE_EXPRESSION.repeat(distance);
    }
}
