package carracing;

public class Car {

    final int ONE_STEP_FORWARD = 1;
    private int maxMovementCount;
    private int carPosition = 0;
    public void carMove(MoveStrategy strategy){
        if(strategy.executeMove()){
            this.carPosition += ONE_STEP_FORWARD;
        }
    }

    public int getCarPosition(){
        return carPosition;
    }

    public void setMaxMovementCount(int moveCount){
        maxMovementCount = moveCount;
    }

    public int getMaxMovementCount(){
        return maxMovementCount;
    }
}
