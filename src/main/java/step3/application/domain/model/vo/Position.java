package step3.application.domain.model.vo;

import error.ErrorMessage;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(ErrorMessage.ERR_NUMBER_RANGE_MESSAGE.print());
        }
    }

    public int add(boolean canMove) {
        return canMove ? ++this.position : this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
