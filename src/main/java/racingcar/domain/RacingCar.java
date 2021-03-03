package racingcar.domain;

public class RacingCar {

    private int travelledDistance;

    private String name;

    private final MovingStrategy movingStrategy;

    public RacingCar(String name, MovingStrategy movingStrategy) {
        this.name = name;
        this.movingStrategy = movingStrategy;
    }

    public RacingCar(String name) {
        this(name,new DecidingNumberBasedMovingStrategy());
    }

    public void move(){
        if(movingStrategy.isMovable())  travelledDistance++;
    }

    public int getTravelledDistance() {
        return travelledDistance;
    }

    public String getName() {
        return name;
    }
}
