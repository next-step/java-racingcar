package step03;

public class RacingCar {

    private int INIT_MOVE_RANGE = 0;
    private int movingRange;
    private MoveStrategy moveStrategy;

    public RacingCar(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        movingRange = INIT_MOVE_RANGE;
    }

    public void tryToMove() {
       if(moveStrategy.move()) {
           movingRange++;
       }
    }

    public int getMovingRange() {
        return movingRange;
    }

}
