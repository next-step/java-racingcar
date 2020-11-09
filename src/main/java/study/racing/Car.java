package study.racing;

public class Car {

    private static final String FORWARD_STRING = "-";
    private static final int INITIAL_POSITION = 0;

    private int position;

    public Car(){
        this.position = INITIAL_POSITION;
    }

    public void move(RacingMoveStrategy racingMoveStrategy){
        position += racingMoveStrategy.getMovement();
    }

    public Integer getPosition() {
        return position;
    }
}

