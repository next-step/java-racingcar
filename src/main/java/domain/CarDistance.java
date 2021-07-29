package domain;

public class CarDistance {

    private int carDistance;

    public CarDistance() {
        carDistance = 0;
    }

    public int takeCarDistance() {
        return carDistance;
    }

    public void addCarDistance(int distance) {
        carDistance += distance;
    }

}
