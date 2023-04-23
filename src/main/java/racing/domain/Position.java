package racing.domain;

public class Position {

    private static final Integer DEFAULT_POSITION = 0;

    private int position;

    public Position() {
        this.position = DEFAULT_POSITION;
    }

    public Position(int position) {
        if (position < DEFAULT_POSITION) {
            throw new RuntimeException("자동차의 위치는 0 이상이어야 합니다.");
        }
        this.position = position;
    }

    public void move() {
        this.position++;
    }

    public boolean isSameWith(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }
}
