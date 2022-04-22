package racing.domain;

import java.util.Objects;

public class Position {
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 0;
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "값은 음수가 될 수 없습니다.";
    private static final String NUMBER_OVER_ERROR_MESSAGE = "값은 10를 초과할 수 없습니다.";

    private int position;

    public Position() {
        this(0);
    }

    public Position(String position) {
        this(Integer.parseInt(position));
    }

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < MIN_NUMBER) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
        if (position > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OVER_ERROR_MESSAGE);
        }
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxPosition(int position) {
        return this.position >= position;
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
        return Objects.hash(position);
    }


    @Override
    public String toString() {
        return "-".repeat(this.position);
    }

}
