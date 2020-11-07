package study1.step3;


public class Car {
    private int moveDistance;

    public Car(int initialNumber){
        this.moveDistance = initialNumber;
    }

    public void move(Decision generator){
        if(generator.moveDecision()){
            this.moveDistance ++;
        }
    }

    public int getMoveDistance(){
        return this.moveDistance;
    }
}
