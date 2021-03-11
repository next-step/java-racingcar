package step3;

public class Car {

    private int currentPosition;

    public void moveForward(int number) {
        if (isAbleToMoveForward(number)) {
            currentPosition++;
        }
    }

    private boolean isAbleToMoveForward(int number) {
        return number >= 4 ? true : false;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }
}
