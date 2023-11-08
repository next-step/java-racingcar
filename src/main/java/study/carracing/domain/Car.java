package study.carracing.domain;

public class Car {

    private static final int INITIAL_POSITION = 1;
    private static final String PROGRESS_DASH = "-";
    private static final int MOVE_CONDITION_NUMBER = 4;

    private int position;
    private final String name;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public void move(int value) {
        if (value >= MOVE_CONDITION_NUMBER) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + PROGRESS_DASH.repeat(position);
    }
}
