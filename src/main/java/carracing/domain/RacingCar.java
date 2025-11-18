package carracing.domain;

public class RacingCar {
    public static final int MOVE_CONDITION = 4;
    private Position position;
    private Name name;

    public RacingCar(String name) {
        this(new Position(), new Name(name));
    }

    public RacingCar(String name, int position) {
        this(new Position(position), new Name(name));
    }

    public RacingCar(Position position, Name name) {
        this.position = position;
        this.name = name;
    }

    public void move(int input) {
        if (input >= MOVE_CONDITION) {
            position = position.increase();
        }
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name.value();
    }

    public boolean isGreaterThanPosition(Position other) {
        return position.isGreaterThanOther(other);
    }
}
