package domain;

public class Position {
    private Integer position;

    public Position(Integer position) {
        this.position = position;
    }

    public Integer value() {
        return this.position;
    }

    public void add(Integer distance) {
        this.position += distance;
    }

    public Position copy() {
        return new Position(this.position);
    }

    public boolean isAheadOf(Position position) {
        return this.position > position.value();
    }

    public boolean equals(Position position) {
        return position.value().equals(this.position);
    }
}
