package game.model;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position1 = (Position) o;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return position;
    }

    public int getPosition() {
        return position;
    }
}
