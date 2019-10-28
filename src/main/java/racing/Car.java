package racing;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int MINIMUM_MOVE_INPUT = 4;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public boolean move(int input) {
        if (input < MINIMUM_MOVE_INPUT) {
            return false;
        }

        position++;
        return true;
    }

    public String getName() {
        return name;
    }

    public int position() {
        return position;
    }
}
