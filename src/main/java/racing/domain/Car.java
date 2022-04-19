package racing.domain;

public class Car {

    private String name;
    private int distance;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int value) {
        if(isAvailableForward(value)) {
            this.distance++;
        }
    }

    private boolean isAvailableForward(int value) {
        if(value >= 4) {
            return true;
        }
        return false;
    }
}
