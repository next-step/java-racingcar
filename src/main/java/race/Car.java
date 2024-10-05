package race;

public class Car {

    public static final int CAR_NAME_LENGTH = 5;

    private final String carName;
    private int position = 1;
    private final ForwardCheck forwardCheck;

    public Car(String carName, ForwardCheck forwardCheck) {
        if (carName.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("CarName is too long");
        }
        this.carName = carName;
        this.forwardCheck = forwardCheck;
    }

    public Car(String carName, int position, ForwardCheck forwardCheck) {
        this.carName = carName;
        this.position = position;
        this.forwardCheck = forwardCheck;
    }

    public void forward() {
        if (checkCarForward()) {
            position++;
        }
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    public int compareWithMaxPosition(int maxPosition) {
        return Math.max(position, maxPosition);
    }

    private boolean checkCarForward() {
        return forwardCheck.isForward();
    }

    public int getForwardResult() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
