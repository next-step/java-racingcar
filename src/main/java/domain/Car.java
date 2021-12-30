package domain;

public class Car {
    private String name;
    private String moving;
    private int distance;

    public Car() {
    }

    public Car(String name, String moving, int distance) {
        this.name = name;
        this.moving = moving;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public String getMoving() {
        return moving;
    }

    public int getDistance() {
        return distance;
    }

    public void setMoving(String moving) {
        this.moving = moving;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
