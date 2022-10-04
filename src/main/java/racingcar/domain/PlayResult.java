package racingcar.domain;

public class PlayResult {

    private final Position position;
    private final Name name;

    public PlayResult(int position, String name) {
        this(new Position(position), new Name(name));
    }

    public PlayResult(Position position, Name name) {
        this.position = position;
        this.name = name;
    }

    public boolean isPositionEquals(Position position) {
        return this.position.equals(position);
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public int getPositionValue() {
        return position.getPosition();
    }

    public String getNameValue() {
        return name.getName();
    }

}
