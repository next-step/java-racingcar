package study.racingcar;

public class Score {

    private final Car car;
    private final MoveStatus moveStatus;

    public final static Character MOVE_SCORE = '-';
    public final static Character STOP_SCORE = Character.MIN_VALUE;

    public Score(Car car) {
        this.car = car;
        this.moveStatus = car.canMove();
    }

    public Character score(){
        if (moveStatus.equals(MoveStatus.MOVE)){
            return MOVE_SCORE;
        }
        return STOP_SCORE;
    }

    public Car whozScore(){
        return car;
    }
}
