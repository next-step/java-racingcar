package step3;

public class Car {

    private static final RandomNumber RANDOM_NUMBER = new RandomNumber();
    private static final int MORE_THAN_NUMBER = 4;

    private int position = 1;

    public void randomNumber() {
        moveCheck(RANDOM_NUMBER.randomNumber());
    }

    private void moveCheck(int random) {
        if (random > MORE_THAN_NUMBER) {
            move();
        }
    }

    private void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

}
