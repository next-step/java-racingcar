package carracing;

public class Car {
    final int RANDOM_RANGE_0_TO_9 = 10;

    private String carName;
    private int maxMovementCount;

    public void setCarName(String name){
        carName = name;
    }

    public String getCarName(){
        return carName;
    }

    public void setMaxMovementCount(int moveCount){
        maxMovementCount = moveCount;
    }

    public int getMaxMovementCount(){
        return maxMovementCount;
    }
}
