package step3;

public class CarMover {
    private static final int MAX = 9;
    private static final int MIN = 0;
    private static final int MOVE_VALUE = 4;

    public void moveOrNot(Car car, int num) {
        if (!isValid(num)) {
            throw new IllegalArgumentException("Number is out of range");
        }
        if (canMove(num)) {
            car.move();
        }
    }

    private boolean canMove(int number) {
        return number >= MOVE_VALUE;
    }

    private boolean isValid(int number) {
        return MIN <= number && number <= MAX;
    }

}
