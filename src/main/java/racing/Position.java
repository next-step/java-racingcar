package racing;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void add(int addend) {
        position += addend;
    }

    public boolean hasPosition(Position position) {
        return this.position == position.position;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            return position == ((Position) obj).position;
        }
        return false;
    }
}
