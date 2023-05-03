package study.domain;

import java.util.Objects;

public class RacingCar {
    private MoveCount moveCount;
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
        this.moveCount = this.moveCount.moveOrStop(randomNumber);
    }

    public boolean isSameMoveCount(MoveCount moveCount) {
        return this.moveCount.checkIsSame(moveCount);
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

    public int getMoveCountValue() {
        return this.moveCount.getCount();
    }

    public MoveCount getMoveCount() {
        return this.moveCount;
    }

}
