package race.domain;

public class Car {

    private static final int FORWARD_STANDARD = 4;
    private static final int MOVE = 1;
    private int position = 0;

    public Car() {}

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean canForward(int random) {
        return random >= FORWARD_STANDARD;
    }

    public void move() {
        this.position += MOVE;
    }
}
