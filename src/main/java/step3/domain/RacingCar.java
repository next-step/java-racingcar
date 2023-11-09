package step3.domain;

public class RacingCar {

    private int distance = 0;

    public int getDistance() {
        return distance;
    }

    public void move() {
        distance += 1;
    }
}
