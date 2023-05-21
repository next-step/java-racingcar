package study.racingcar;

public class RacingCar {

    private String carName;
    private int forwardCount;

    private final String locationString = "-";

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

    public String viewLocation() {
        String result = "";
        for (int i = 0; i < forwardCount; i++) {
            result += locationString;
        }
        return result;
    }

    public String carStatus() {
        return carName + " : " + viewLocation();
    }

}
