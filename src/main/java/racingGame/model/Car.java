package racingGame.model;

public class Car {
    
    public static final int INIT_LOCATION = 1;
    public static final int CAR_FORWARD_CRITERIA = 3;
    private int location;
    
    public Car() {
        this.location = INIT_LOCATION;
    }
    
    public int forward(int randomNum) {
        if (randomNum > CAR_FORWARD_CRITERIA) {
            location += 1;
        }
        return location;
    }
    
    public int findLocation() {
        return location;
    }
}
