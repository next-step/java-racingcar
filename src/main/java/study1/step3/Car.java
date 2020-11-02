package study1.step3;


public class Car {
    private String moveDistance = "-";

    void move(){
        this.moveDistance += "-";
    }

    public String getMoveDistance(){
        return this.moveDistance;
    };
}
