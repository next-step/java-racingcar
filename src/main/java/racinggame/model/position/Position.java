package racinggame.model.position;

import java.util.Objects;

public class Position {
    private static final int DEFAULT_POSITION = 0;
    private static final int PLUS_POSITION = 1;

    private int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int position) {
        if (position < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다");
        }

        this.position = position;
    }

    public void plus() {
        this.position += PLUS_POSITION;
    }

    public boolean hasDownPosition(Position checkPosition) {
        return this.position < checkPosition.value();
    }

    public String getStateMessage() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    private int value() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
