package stage4;

public class ResultValue {
    private final String carName;
    private final int currentStatus;

    public ResultValue (String carName, int currentStatus) {
        this.carName = carName;
        this.currentStatus = currentStatus;
    }

    public int getCurrentStatus() {
        return this.currentStatus;
    }

    public String getCarName() {
        return this.carName;
    }
}
