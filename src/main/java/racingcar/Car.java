package racingcar;

public class Car {

    private int travelDistance;

    public void move(){
        RandomGenerator randomGenerator = new RandomGenerator();
        if(randomGenerator.getRandomNumber() >= 4) {
            this.travelDistance++;
        }
    }

    public int getTravelDistance(){
        return this.travelDistance;
    }

}
