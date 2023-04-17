package study;

import java.util.Objects;

public class RacingCar {
    private int moveCount = 0;
    private String name;

    private static final int MAX_LENGTH_OF_NAME = 5;

    public RacingCar(String name) {
        if (name.length() >= MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("사용자의 이름의 길이는 5이상으로 작성할수 없습니다.");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return moveCount == racingCar.moveCount && name.equals(racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveCount, name);
    }

    public void moveOrStop(int randomNumber) {
        if (MoveChecker.canMoveForward(randomNumber)) {
            moveForward();
        }
    }

    public String getName() {
        return this.name;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    private void moveForward() {
        this.moveCount++;
    }
}
