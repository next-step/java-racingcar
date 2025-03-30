package domain;

public class RacingCarCurrentStatus {
    private final String name;
    private final Position position;

    protected RacingCarCurrentStatus(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String name() {
        return this.name;
    }

    public Position position() {
        return this.position;
    }

    public boolean isAheadOf(Position maxPosition) {
        return this.position.isAheadOf(maxPosition);
    }

    public boolean isSameOf(Position position) {
        return this.position.equals(position);
    }
}
