package car.domain;

public class RacingCar {
    private int moveCount;

    public void move() {
        moveCount++;
    }


    public int getMoveCount() {
        return moveCount;
    }
}
