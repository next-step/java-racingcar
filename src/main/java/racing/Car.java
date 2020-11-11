package racing;

public class Car {

    private int travelDistance = 0;

    public void move(int randomNumber) {
        int FORWARD_CONDITION = 4;
        if (randomNumber >= FORWARD_CONDITION) {
            travelDistance++;
        }
    }

    public int getTravelDistance() {
        return travelDistance;
    }
}
