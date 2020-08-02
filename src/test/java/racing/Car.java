package racing;

public class Car {

    private int totalDistance = 0;

    public void move(int distance) {
        totalDistance += distance;
    }

    public int getTotalDistance() {
        return totalDistance;
    }
}
