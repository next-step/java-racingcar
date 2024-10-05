package race;

public class Car {

    public static final int CAR_NAME_LENGTH = 5;
    private final String carName;
    private int forwardResult = 1;
    private final ForwardCheck carForwardCheck;

    public Car(String carName, ForwardCheck carForwardCheck) {
        if (carName.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("CarName is too long");
        }
        this.carName = carName;
        this.carForwardCheck = carForwardCheck;
    }

    public void forward() {
        if (checkCarForward()) {
            forwardResult++;
        }
    }

    public boolean isMaxPosition(int maxPosition) {
        return forwardResult == maxPosition;
    }

    public int compareWithMaxPosition(int maxPosition) {
        if (forwardResult > maxPosition) {
            return forwardResult;
        }
        return maxPosition;
    }

    private boolean checkCarForward() {
        return carForwardCheck.isForward();
    }

    public int getForwardResult() {
        return forwardResult;
    }

    public String getCarName() {
        return carName;
    }
}
