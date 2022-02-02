package racing.domain.car;

public class CarHistory {

    private final Name name;
    private final Position position;

    public CarHistory(Name name, Position position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Name getName() {
        return name;
    }

    public int getPositionValue() {
        return position.getValue();
    }
}
