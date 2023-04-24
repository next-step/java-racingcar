package study.domain;

import study.utils.MoveChecker;

import java.util.Objects;

public class RacingCar {
    private final MoveCount moveCount;
    private final Name name;

    public RacingCar(String name) {
        this.name = new Name(name);
        this.moveCount = new MoveCount();
    }

    public RacingCar(String name, int moveCount) {
        this.name = new Name(name);
        this.moveCount = new MoveCount(moveCount);
    }

    public void moveOrStop(int randomNumber) {
        if (MoveChecker.canMoveForward(randomNumber)) {
            moveForward();
        }
    }

    public boolean isSameMoveCount(int maxCountValue) {
        return moveCount.checkIsSame(maxCountValue);
    }

    private void moveForward() {
        this.moveCount.moveForward();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(moveCount, racingCar.moveCount) && Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveCount, name);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getMoveCount() {
        return this.moveCount.getCount();
    }

}
