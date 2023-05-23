package study.racingcar;

public class RacingCar {

    private String carName;
    private int forwardCount;

    public RacingCar() {
    }

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getForwardCount() {
        return forwardCount;
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

    }
}
