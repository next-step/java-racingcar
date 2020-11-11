package racing;

public class Car {

    private static final int FORWARD_CONDITION = 4;
    private int travelDistance = 0;

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_CONDITION) {
            travelDistance++;
        }
    }

    public int getTravelDistance() {
        return travelDistance;
    }
}
