package model;

public class Car {
    private static final int CAR_MOVE_BOUNDARY = 4;
    private CarName carName;
    private int position;

    public Car(int position, String name) {
        this.position = position;
        this.carName = new CarName(name);
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

    public String name() {
        return carName.toString();
    }

    public String toString() {
        return String.format("%s : %s", carName, "-".repeat(position));
    }

}
