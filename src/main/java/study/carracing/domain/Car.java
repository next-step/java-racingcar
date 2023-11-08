package study.carracing.domain;

public class Car {

    private static final String PROGRESS_DASH = "-";
    private static final int MOVE_CONDITION_NUMBER = 4;

    private int position = 1;
    private final String name;

    public Car(String name) {
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

    @Override
    public String toString() {
        return name + " : " + PROGRESS_DASH.repeat(position);
    }
}
