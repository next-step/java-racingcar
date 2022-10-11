package racing.core;

public class Car {

    private int distance = 1;
    private final String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getCarName(){
        return this.carName;
    }

    public void stepAhead(int stepCount) {
        this.distance += stepCount;
    }

    @Override
    public String toString() {
        return carName;
    }
}
