package racingcar;

public class Car {

    private int travelDistance;
    private RandomGenerator randomGenerator = new RandomGenerator();

    public void move(){

        if(randomGenerator.getRandomNumber() >= 4) {
            this.travelDistance++;
        }
    }

    public int getTravelDistance(){
        return this.travelDistance;
    }

}
