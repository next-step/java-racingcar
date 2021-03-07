package study;

public class Car {
    private int position;
    public Car(){
        this.position = 1;
    }
    public void move(){
        if(NumberChecker.checkCondition()){
            position = position + 1;
        }
    }
}
