package domain;

public class Car {
    private String name;
    private String moving;
    private int distance;
    private String status;

    public Car() {
    }

    public Car(String name, String moving, int distance, String status) {
        this.name = name;
        this.moving = moving;
        this.distance = 0;
        this.status = status;
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

    public void setStatus(String status) {
        this.status = status;
    }
}
