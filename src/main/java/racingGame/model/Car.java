package racingGame.model;

public class Car {
    
    private int location;
    
    public Car() {
        this.location = 1;
    }
    
    public void move() {
        location ++;
    }
    
    public int findLocation() {
        return location;
    }
}
