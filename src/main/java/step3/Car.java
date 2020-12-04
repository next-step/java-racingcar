package step3;

public class Car {

    private StringBuilder distance;

    public Car() {
        this.distance = new StringBuilder();
    }

    public void move(int random) {
        if (Checkor.check(random)) {
            distance.append("-");
        }
    }

    public String getDistance() {
        return distance.toString();
    }
}
