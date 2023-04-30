package racing.model;

public class Position {

    public static final int DEFAULT_POSITION = 0;
    private int position;

    public Position() {
        this.position = DEFAULT_POSITION;
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalStateException("음수값을 가질 수 없습니다.");
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }
}
