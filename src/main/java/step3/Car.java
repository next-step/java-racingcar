package step3;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private int distance;

    public int getDistance() {
        return distance;
    }

    public void setDistance() {
        this.distance++;
    }

    public boolean isMove(int randomValue) {
        return MOVE_CONDITION <= randomValue;
    }
}