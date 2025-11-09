package racingGame.model;

public class Car {
    
    public static final int INIT_LOCATION = 1;
    private int location;
    
    public Car() {
        this.location = INIT_LOCATION;
    }
    
    public void move() {
        location ++;
    }
    
    public int findLocation() {
        return location;
    }
}
