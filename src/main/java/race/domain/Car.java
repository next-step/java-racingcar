package race.domain;

public class Car {

    private static final int STANDARD_BOUND = 4;

    private int position;

    public int getPosition() {
        return this.position;
    }

    public void go(int randomNumber) {
        if (randomNumber >= STANDARD_BOUND) {
            this.position++;
        }
    }

}
