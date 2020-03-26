package step5.domain;

import java.util.Objects;

class Position {
    private static final int FORWARD_STATUS_VALUE = 4;
    private static final String FORWARD_VALUE = "-";
    private static final String STOP_VALUE = "";

    private String position;

    public Position(String position) {
        this.position = position;
    }

    Position move(int randomNumber) {
        position += forwardStatus(randomNumber);
        return new Position(position);
    }

    private String forwardStatus(int randomNumber) {
        if (randomNumber < FORWARD_STATUS_VALUE) {
            return STOP_VALUE;
        }
        return FORWARD_VALUE;
    }

    String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        final Position position1 = (Position) o;
        return Objects.equals(position, position1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
