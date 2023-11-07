package racewinner.domain;

import java.util.Objects;

public class Position {
    private int position;
    private final static String NEGATIVE_NUMBER_MSG = "position 객체는 음수를 가질 수 없습니다.";
    private final int NEGATIVE_NUMBER = 0;
    public Position(final int position) {
        validationCheck(position);

        this.position = position;
    }

    private void validationCheck(final int position) {
        if (position < NEGATIVE_NUMBER) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_MSG);
        }
    }

    public void move() {
        this.position++;
    }

    public int get() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
