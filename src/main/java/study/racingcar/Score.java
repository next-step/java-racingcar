package study.racingcar;

import java.util.Objects;

public class Score {

    private final Car car;
    private final MoveStatus moveStatus;

    public Score(Car car, RandomGenerator randomGenerator) {
        this.car = car;
        this.moveStatus = car.canMove(randomGenerator);
    }

    public MoveStatus scoreMoveStatus(){
        if (moveStatus.equals(MoveStatus.MOVE)){
            return MoveStatus.MOVE;
        }
        return MoveStatus.STOP;
    }

    public Car whozScore() {
        return car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Score score = (Score) o;
        return Objects.equals(car, score.car) && moveStatus == score.moveStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, moveStatus);
    }
}
