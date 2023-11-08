package step3.model;

public class CarMoving implements Moving {

    private int movingDistance;

    public CarMoving() {}

    public CarMoving(int movingDistance) {
        this.movingDistance = movingDistance;
    }

    @Override
    public void move(Integer randomNumber) {
        if (randomNumber >= 4) {
            movingDistance++;
        }
    }

    @Override
    public int getMovingDistance() {
        return movingDistance;
    }
}