package racing.domain;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private int distance;

    public int getDistance() {
        return distance;
    }

    public void move(int randomValue) {
        if (MOVE_CONDITION <= randomValue) {
            this.distance++;
        }
    }
}