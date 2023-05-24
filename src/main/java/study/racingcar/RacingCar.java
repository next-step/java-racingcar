package study.racingcar;

public class RacingCar {

    public static final int CAR_NAME_LIMIT = 5;

    private String carName;
    private int forwardCount;
    private boolean brokeAt = false;

    public RacingCar() {
    }

    public RacingCar(String carName) {
        this.carName = carName;
        checkCarName(carName);
    }

    public String getCarName() {
        return carName;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public boolean isBrokeAt() {
        return brokeAt;
    }

    public void forward() {
        this.forwardCount++;
    }

    public void forwardAndStop(int number) {
        if (number >= 4) {
            forward();
        }
    }

    public void checkCarName(String carName) {
        if (carName.length() > CAR_NAME_LIMIT) {
            this.brokeAt = true;
        }
    }
}
