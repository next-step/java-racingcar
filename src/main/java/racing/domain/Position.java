package racing.domain;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public Position() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public Position move() {
        this.position++ ;
        return this;
    }

    public boolean samePosition(int position) {
        return this.position == position;
    }

    public boolean isGreaterThan(int maxPosition) {
        return  this.position > maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position that = (Position) o;

        return position == that.position;
    }

    @Override
    public int hashCode() {
        return position;
    }
}
