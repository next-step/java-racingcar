package study.racingcar;

public class Score {

    public static final String MOVE_SCORE = "-";
    public static final String STOP_SCORE = "";

    private final Car car;
    private final MoveStatus moveStatus;

    public Score(Car car) {
        this.car = car;
        this.moveStatus = car.canMove();
    }

    public String score(){
        if (moveStatus.equals(MoveStatus.MOVE)){
            return MOVE_SCORE;
        }
        return STOP_SCORE;
    }

    public Car whozScore() {
        return car;
    }
}
