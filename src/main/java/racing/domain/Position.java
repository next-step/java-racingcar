package racing.domain;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Position 은 음수 값을 가질 수 없습니다");
        }
        this.position = position;
    }

    public Position move() {
        position += 1;
        return this;
    }

    public boolean isSame(int position) {
        return this.position == position;
    }
}
