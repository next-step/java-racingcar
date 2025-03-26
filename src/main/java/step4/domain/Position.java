package step4.domain;

public class Position implements Comparable<Position> {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position ++;
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.position, other.position);
    }
}
