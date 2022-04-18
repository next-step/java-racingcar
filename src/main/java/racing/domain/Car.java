package racing.domain;

public class Car {

    private int distance;

    public int getDistance() {
        return distance;
    }

    public void move(int value) {
        if(isAvailableForward(value)) {
            this.distance++;
        }
    }

    private boolean isAvailableForward(int value) {
        if(value >= 4) {
            return true;
        }
        return false;
    }
}
