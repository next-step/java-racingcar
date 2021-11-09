package racing.model;

public class Car {

    private int movingDistance = 0;

    public void go() {
        movingDistance++;
    }

    public int getMovingDistance() {
        return movingDistance;
    }
}
