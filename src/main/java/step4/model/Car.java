package step4.model;


public class Car {

    private static final int MIN_GO_VALUE = 4;
    private static final int MAX_GO_VALUE = 9;
    private static final int INITIAL_DISTANCE = 0;
    private static final String DISTANCE_EXPRESSION = "-";

    private String name;
    private int distance;

    private Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car makeCar(String name) {
        return new Car(name, INITIAL_DISTANCE);
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
        return name + " : " + DISTANCE_EXPRESSION.repeat(distance);
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
