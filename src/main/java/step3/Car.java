package step3;

public class Car {

    private static final int ENABLE_MOVE_NUMBER = 4;
    private int travelDistance;

    public void move(int randomNumber) {
        if (randomNumber >= ENABLE_MOVE_NUMBER) {
            this.travelDistance++;
        }
    }

    public int getTravelDistance() {
        return this.travelDistance;
    }
}