package step5.racing.domain;


public class CarResult {

    private final CarName name;
    private final Position position;

    public CarResult(String name, int position) {
        this(new CarName(name), new Position(position));
    }

    public CarResult(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public CarName name() {
        return name;
    }

    public Position position() {
        return position;
    }

    public boolean isMaxPosition(Position maxPosition) {
        return this.position.equals(maxPosition);
    }
}
