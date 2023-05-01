package carracing.domain;

public class Car {
    private static final int MINIMUM_SPEED = 4;
    private final Name name;
    private Position position;


    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public int move(int speed) {
        if (speed >= MINIMUM_SPEED) {
            position = position.increase();
        }
        return this.position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean isWinner(int maxPosition) {
        return maxPosition == position.getPosition();
    }
}
