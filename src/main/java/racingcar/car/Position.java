package racingcar.car;

import racingcar.random.RandNum;

public class Position {
    private final static int DEFAULT_LOCATION = 0;
    private final static int MOVE_CRITERIA = 4;

    private final int location;

    public Position(int location) {
        if(location < DEFAULT_LOCATION) {
            throw new IllegalArgumentException("위치는 0보다 작을 수 없습니다.");
        }
        this.location = location;
    }

    public Position() {
        this(DEFAULT_LOCATION);
    }

    public boolean isGreaterThan(Position location) {
        return this.location >= location.getLocation();
    }

    public Position max(Position criteria) {
        return new Position(Math.max(this.location, criteria.getLocation()));
    }

    public Position move(RandNum randNum) {
        if (randNum.isGreaterThan(MOVE_CRITERIA)) {
            return new Position(this.location + 1);
        }

        return this;
    }

    public int getLocation() {
        return this.location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        return location == position.location;
    }

    @Override
    public int hashCode() {
        return location;
    }
}
