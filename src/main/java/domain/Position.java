package domain;

public class Position {
    private Integer position;

    public Position(Integer position) {
        this.position = position;
    }

    public Integer position() {
        return this.position;
    }

    public void add(Integer distance) {
        this.position += distance;
    }

    public Position copy() {
        return new Position(this.position);
    }

}
