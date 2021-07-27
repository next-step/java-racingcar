package domain;

public class CarDistance {

    private int carDistance;

    public CarDistance() {
        carDistance = 0;
    }

    public int checkCarDistance() {
        return carDistance;
    }

    public void changeCarDistance(int distance) {
        carDistance += distance;
    }

}
