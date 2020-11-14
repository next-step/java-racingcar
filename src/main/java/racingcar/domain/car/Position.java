package racingcar.domain.car;

public class Position {
    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Position position = (Position) obj;
        return value == position.getValue();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
