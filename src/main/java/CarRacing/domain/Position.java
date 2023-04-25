package CarRacing.domain;

public class Position {
    private static final int INITIAL_POSITION = 1;

    private final int position;

    public Position() {
        this.position = INITIAL_POSITION;
    }

    public Position(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("위치는 음수일 수 없습니다.");
        }

        this.position = number;
    }

    public Position move(int number) {
        return new Position(this.position + number);
    }

    public int currentPosition() {
        return this.position;
    }
}
