package racingCar.model;

public class Car {
    private static final int CAN_MOVE_NUMBER = 4;

    private int location = 0;

    public boolean canMove(int randomNumber) {
        return randomNumber >= CAN_MOVE_NUMBER;
    }

    public int move(int randomNumber) {
        if (canMove(randomNumber)) {
            location++;
        }
        return location;
    }

    public int getLocation() {
        return location;
    }

}
