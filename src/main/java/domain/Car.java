package domain;

public class Car {

    private final int INITIAL_LOCATION = 1;

    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = INITIAL_LOCATION;
    }

    public void move() {
        this.location++;
    }

    public String getName() {
        return this.name;
    }

    public int getCurrentLocation() {
        return this.location;
    }

}
