package step3.domain;

public class CarRunResult {

    private CarName carName;
    private int runDistance;

    public CarRunResult(CarName carName, int runDistance) {
        this.carName = carName;
        this.runDistance = runDistance;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public String getCarNameString() {
        return carName.getString();
    }
}
