package study1.step3;


public class Car {
    private int moveDistance = 1;

    void move(Decision generator){
        if(generator.moveDecision()){
            this.moveDistance ++;
        }
    }

    public int getMoveDistance(){
        return this.moveDistance;
    }
}
