package car.step3.domain;

public class Position {
    private int position;

    public Position(int position) {
        if(position < 0 ) {
            throw new IllegalArgumentException("position 은 음수 값을 가질 수 없습니다.");
        }
        this.position = position;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public boolean lessThan(Position maxPosition) {
        return maxPosition.getPosition() > this.position;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position1 = (Position) o;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return position;
    }
}
