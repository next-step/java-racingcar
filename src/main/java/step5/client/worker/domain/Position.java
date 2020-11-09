package step5.client.worker.domain;

import common.util.Message;

import java.util.Objects;

import static common.util.Preconditions.checkArgument;
import static step5.client.worker.domain.Position.ErrorMessage.POSITION_VALUE_MUST_MORE_THEN_ZERO;

public class Position {
    public enum ErrorMessage implements Message {
        POSITION_VALUE_MUST_MORE_THEN_ZERO("position must more then 0"),
        ;

        private final String message;

        public String getMessage() {
            return message;
        }

        ErrorMessage(String message) {
            this.message = message;
        }
    }
    
    private int value;

    private Position(int value) {
        this.value = value;
    }

    public static Position of(final int value) {
        checkArgument(value >= 0, POSITION_VALUE_MUST_MORE_THEN_ZERO);
        return new Position(value);
    }

    public void increase(final int unit) {
        value += unit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
