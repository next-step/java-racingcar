package study.racingcar;

public class Score {

    private final Car car;
    private final MoveStatus moveStatus;

    public final static String MOVE_SCORE = "-";
    public final static String STOP_SCORE = "";

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
