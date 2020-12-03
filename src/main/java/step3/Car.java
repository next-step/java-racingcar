package step3;

public class Car {

    StringBuilder distance;

    public Car() {
        this.distance = new StringBuilder();
    }

    public void move() {
        distance.append("-");
    }

    public String getDistance() {
        return distance.toString();
    }
}
