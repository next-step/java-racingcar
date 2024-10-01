package racing.car;

public class Car {
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;
    private static final int STANDARD = 4;

    boolean isGo;
    int position;

    public Car(int position) {
        this.position = position;
    }

    public boolean isGo(int randomNumber) {
        if (randomNumber < MIN_BOUND || randomNumber > MAX_BOUND) {
            throw new IllegalArgumentException();
        }
        if (randomNumber >= STANDARD) {
            position++;
            return true;
        }
        return isGo;
    }

    public int getPosition() {
        return position;
    }
}
