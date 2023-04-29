package carracing;

public class Car {
    private static final int MINIMUM_SPEED = 4;
    private final Name name;
    private Position position;


    public Car(final Name name) {
        this(name, new Position(0));
    }

    public Car(final Name name, Position position) {
        this.name = name;
        this.position = position;
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
