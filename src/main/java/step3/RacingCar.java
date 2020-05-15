package step3;

public class RacingCar {

    private int carNumber;
    private int position;

    private RacingCar(int carNumber) {
        this.carNumber = carNumber;
    }

    public static RacingCar create(int carNumber) {
        return new RacingCar(carNumber);
    }

    public int move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.moveCurrentPosition();
        }

        return position;
    }

    private void moveCurrentPosition() {
        this.position += 1;
    }
}
