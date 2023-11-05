package carRacing;

public class Car {

    private static final int STANDARD_MOVE_VALUE = 4;
    private static final int START_POSITION = 1;
    private int position;

    public Car() {
        this.position = START_POSITION;
    }

    public void move() {
        if (checkStandardMove()) {
            position += 1;
        }
    }

    public void move(int value) {
        if (value >= 4) {
            position += 1;
        }
    }

    private boolean checkStandardMove() {
        RandomCreate randomCreate = new RandomCreate();
        int randomNumber = randomCreate.randomNumber();

        return randomNumber >= STANDARD_MOVE_VALUE;
    }

    public int getPosition() {
        return position;
    }

}
