package racingcar;

public class Car {

    private int travelDistance;

    public void move(){
        if(RandomGenerator.getRandomNumber() >= 4) {
            this.travelDistance++;
        }
    }

    public int getTravelDistance(){
        return this.travelDistance;
    }

}
