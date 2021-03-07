package study.step3;

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
