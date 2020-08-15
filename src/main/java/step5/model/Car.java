package step5.model;

public class Car {
    private final String name;
    private int distance;

    public Car(String john) {
        this.name = john;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void goForward() {
        this.distance++;
    }
}
