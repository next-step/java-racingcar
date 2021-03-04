package racingcar.domain;

public class RacingCar {

    private int travelledDistance;
    
    private final MovingStrategy movingStrategy;

    public RacingCar(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public RacingCar() {
        this(new DecidingNumberBasedMovingStrategy());
    }

    public void move(){
        if(movingStrategy.isMovable()){
            travelledDistance++;
        }
    }

    public int getTravelledDistance() {
        return travelledDistance;
    }
    
}
