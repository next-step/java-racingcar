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

    public Integer position() {
        return this.position.position();
    }
}
