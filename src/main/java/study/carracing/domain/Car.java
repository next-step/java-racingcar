package study.carracing.domain;

public class Car {

    private static final String PROGRESS_DASH = "-";
    private static final int MOVE_CONDITION_NUMBER = 4;

    private final Position position;

    private final Name name;

    public Car(Name name) {
        this(new Position(), name);
    }

    public Car(Position position, Name name) {
        this.position = position;
        this.name = name;
    }

    public void move(int value) {
        if (value >= MOVE_CONDITION_NUMBER) {
            position.plusPosition();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public String toString() {
        return getName() + " : " + PROGRESS_DASH.repeat(getPosition());
    }

    public int compareToMaxPosition(int maxPosition) {
        return this.position.compareToMaxPosition(maxPosition);
    }

    public boolean isSame(int maxPosition) {
        return this.position.isSame(maxPosition);
    }
}
