package racingcar.step5.domain;

import java.util.Objects;

import static racingcar.step5.message.ErrorMessage.*;
import static racingcar.step5.message.ViewMessage.*;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(NO_ZERO_LESS_MESSAGE);
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void addPosition() {
        this.position++;
    }

    public boolean isMoreThan(Position position) {
        return this.position > position.getPosition();
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

}
