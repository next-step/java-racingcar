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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean isMaxPosition(int max) {
        return this.position >= max;
    }
}
