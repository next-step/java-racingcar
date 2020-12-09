package step3;

public class CarMover {

    private static final int MOVE_VALUE = 4;

    public void moveOrNot(Car car, int num) {
        if (canMove(num)) {
            car.move();
        }
    }

    private boolean canMove(int number) {
        return number >= MOVE_VALUE;
    }

}
