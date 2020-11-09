package racingcar;

public class Car {

    private int travelDistance;

    public void forward(){
        this.travelDistance++;
    }

    public int getTravelDistance(){
        return this.travelDistance;
    }

}
