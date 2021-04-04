package car.domain;

public class RacingCar {
    private final String carName;
    private int moveCount;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public void move() {
        moveCount++;
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
