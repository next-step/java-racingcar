package study.racing;

public class Car {

    private static final int INITIAL_POSITION = 0;

    private int position;

    private String carName;

    public Car(String carName){
        this.carName = carName;
        this.position = INITIAL_POSITION;
    }

    public void move(RacingMoveStrategy racingMoveStrategy){
        position += racingMoveStrategy.getMovement();
    }

    public String getCarName(){return carName;}
    public Integer getPosition() {
        return position;
    }
}

