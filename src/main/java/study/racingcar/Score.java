package study.racingcar;

public class Score {

    private final Car car;
    private final MoveStatus moveStatus;

    public Score(Car car, RandomGenerator randomGenerator) {
        this.car = car;
        this.moveStatus = car.canMove(randomGenerator);
    }

    public MoveStatus score() {
        if (moveStatus.equals(MoveStatus.MOVE)) {
            return MoveStatus.MOVE;
        }
        return MoveStatus.STOP;
    }

    public Car whozScore() {
        return car;
    }
}
