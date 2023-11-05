package carRacing;

public class Car {

    private static final int STANDARD_MOVE_VALUE = 4;
    private static final int START_POSITION = 1;
    private final RandomCreate randomCreate;
    private int position;

    public Car() {
        this.position = START_POSITION;
        this.randomCreate = new RandomCreate();
    }

    public void move() {
        if (checkStandardMove()) {
            position += 1;
        }
    }

    private boolean checkStandardMove() {
        return randomCreate.randomNumber() >= STANDARD_MOVE_VALUE;
    }

    public int getPosition() {
        return position;
    }

}
