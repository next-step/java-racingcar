package carracing.domain;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        checkPosition(position);

        this.position = position;
    }

    private void checkPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("현재 위치는 음수가 될 수 없습니다.");
        }
    }

    public void move() {
        this.position++;
    }

}
