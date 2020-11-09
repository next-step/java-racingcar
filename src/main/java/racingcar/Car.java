package racingcar;

public class Car {

    private int travelDistance;

    public void move(){
        this.travelDistance++;
    }

    public int getTravelDistance(){
        return this.travelDistance;
    }

}
