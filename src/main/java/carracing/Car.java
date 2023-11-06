package carracing;

public class Car {

    private static final int STANDARD_MOVE_VALUE = 4;
    private static final int START_POSITION = 1;
    private int position;

    public Car() {
        this.position = START_POSITION;
    }

    public void move(int randomNumber) {
        if (checkStandardMove(randomNumber)) {
            position += 1;
        }
    }

    private boolean checkStandardMove(int randomNumber) {

        return randomNumber >= STANDARD_MOVE_VALUE;
    }

    public int getPosition() {
        return position;
    }

}
