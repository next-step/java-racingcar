package step3;

public class Car {

    private int location = 0;

    private static final Integer bound = 9;

    public void move(int value) {
        if (value > bound || value < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANDOM_VALUE);
        }
        if (value > 4) {
            goForward();
        }
    }

    private void goForward() {
        location++;
    }

    public int getLocation() {
        return location;
    }

}
