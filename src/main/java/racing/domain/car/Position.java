package racing.domain.car;

import java.util.Objects;
import racing.domain.car.exception.NegativePositionException;

public class Position {

    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        validation(position);
        this.position = position;
    }

    private void validation(int state) {
        if (state < 0) {
            throw new NegativePositionException("음수의 전진 상태는 존재하지 않습니다.");
        }
    }

    public Position advance() {
        return new Position(position + 1);
    }

    public int value() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
