package study.racing;

public class Car {

    private int carCount;
    private int tryCount;

    public Car() {

    }

    public Car(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }
}
