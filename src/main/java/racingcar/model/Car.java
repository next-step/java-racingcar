package racingcar.model;

public class Car {
    private static final int RANDOM_VALUE_RANGE = 9;
    private static final int SUCCESS_MINIMUM_VALUE = 4;
    private int position;

    public Car() {
        this.position = 1;
    }

    public void moveCar(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public void moveOnce() {
        int randomNumber = generateRandomNumber();
        boolean canMove = tryToMove(randomNumber);
        moveCar(canMove);
    }

    public int getPosition() {
        return position;
    }

    public boolean tryToMove(int random) {
        return random >= SUCCESS_MINIMUM_VALUE;
    }

    public int generateRandomNumber() {
        return (int) (Math.floor(Math.random() * (Car.RANDOM_VALUE_RANGE + 1)));
    }

}
