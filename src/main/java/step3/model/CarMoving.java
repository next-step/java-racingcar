package step3.model;

public class CarMoving implements Moving {

    private int movingDistance;

    private static final int MINIMAL_RANDOM_NUMBER = 4;

    public CarMoving() {}

    public CarMoving(int movingDistance) {
        this.movingDistance = movingDistance;
    }

    @Override
    public void move(Integer randomNumber) {
        if (randomNumber >= MINIMAL_RANDOM_NUMBER) {
            movingDistance++;
        }
    }

    @Override
    public int getMovingDistance() {
        return movingDistance;
    }
}
