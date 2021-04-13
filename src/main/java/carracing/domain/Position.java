package carracing.domain;

public class Position {

    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        if (position < 0)
            throw new IllegalArgumentException("position값은 0 이상이어야 합니다.");

        this.position = position;
    }

    public Position move() {
        return new Position(this.position++);
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isMaxPosition(int max) {
        return this.position >= max;
    }
}
