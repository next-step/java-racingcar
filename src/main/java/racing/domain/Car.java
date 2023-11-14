package racing.domain;

public class Car {

    private static final int ACCEPT_MOVE_NUMBER = 4;

    private final String name;
    private int position;

    public Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void tryMove(int number) {
        if (number >= ACCEPT_MOVE_NUMBER) {
            position++;
        }
    }
}
