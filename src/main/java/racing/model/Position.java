package racing.model;

public class Position {

    private Integer position;

    public Position() {
        this.position = 0;
    }

    public void move() {
        this.position ++;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position1 = (Position) o;

        return position != null ? position.equals(position1.position) : position1.position == null;
    }

    @Override
    public int hashCode() {
        return position != null ? position.hashCode() : 0;
    }
}
