package study;

import java.util.Objects;

public class RacingCar {
    private MoveCount moveCount;
    private Name name;

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

    public String getName() {
        return this.name.getName();
    }

    public int getMoveCount() {
        return this.moveCount.getCount();
    }

    public boolean isSameMoveCount(int maxCountValue) {
        return moveCount.checkIsSame(maxCountValue);
    }

    private void moveForward() {
        this.moveCount.moveForward();
    }


}
