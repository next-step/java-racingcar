package car.domain;

public class RacingCar {
    private String carName;
    private int moveCount;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public void move() {
        moveCount++;
    }


    public int getMoveCount() {
        return moveCount;
    }
}
