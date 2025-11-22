package Model;

public class Car {
    private static final int CAR_MOVE_BOUNDARY = 4;

    private int position;

    public Car(int position) {
        this.position = position;
    }

    private boolean canMoveForward(int randomNumber) {
        return randomNumber >= CAR_MOVE_BOUNDARY;
    }

    public void tryMoveForward(int randomNumber) {
        if (canMoveForward(randomNumber)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
