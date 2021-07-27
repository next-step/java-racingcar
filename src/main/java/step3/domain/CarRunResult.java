package step3.domain;

public class CarRunResult {

    private String carName;
    private int runDistance;

    public CarRunResult(String carName, int runDistance) {
        this.carName = carName;
        this.runDistance = runDistance;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public String getCarName() {
        return carName;
    }
}
