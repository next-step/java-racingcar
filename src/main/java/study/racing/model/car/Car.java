package study.racing.model.car;

public class Car {

    private static final int CRITERIA = 4;

    private int distance;

    public void moveOrStop(int number) {
        if (number >= CRITERIA) {
            this.distance++;
        }
    }

    public int getDistance() {
        return distance;
    }
}
