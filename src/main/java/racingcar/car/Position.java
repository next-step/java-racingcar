package racingcar.car;

import racingcar.random.RandNum;

public class Position {
    private final static int DEFAULT_LOCATION = 0;
    private final static int MOVE_CRITERIA = 4;

    private int location;

    public Position(int location) {
        if(location < DEFAULT_LOCATION) {
            throw new IllegalArgumentException("위치는 0보다 작을 수 없습니다.");
        }
        this.location = location;
    }

    public Position() {
        this(DEFAULT_LOCATION);
    }

    public boolean isGreaterThan(int location) {
        return this.location >= location;
    }

    public int max(int criteria) {
        return Math.max(this.location, criteria);
    }

    public void move(RandNum randNum) {
        if (randNum.isGreaterThan(MOVE_CRITERIA)) {
            this.location++;
        }
    }

    public int getLocation() {
        return this.location;
    }
}
