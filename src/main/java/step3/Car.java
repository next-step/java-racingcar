package step3;

public class Car {

    private final int ENABLE_MOVE_NUMBER = 4;
    private int travelDistance;
    private RandomGenerator randomGenerator = new RandomGenerator();

    public void move(int randomNumber) {
        if (randomNumber >= ENABLE_MOVE_NUMBER) {
            this.travelDistance++;
        }
    }

    public int getTravelDistance() {
        return this.travelDistance;
    }
}