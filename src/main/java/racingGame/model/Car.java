package racingGame.model;

public class Car {
    
    private int location;
    
    public Car() {
    }
    
    public void init() {
        this.location = 0;
    }
    
    public void move() {
        location++;
    }
    
    public int findLocation() {
        return location;
    }
}
