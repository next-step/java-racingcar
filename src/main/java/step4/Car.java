package step4;

public class Car {
    private final String carName;
    private int distance;

    private static final int goCar = 4;

    public Car(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public Car(String carName) {
        this(carName, 0);
    }

    public void carCanGoJudge(int randomNumber) {
        if (randomNumber >= goCar) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }
}
