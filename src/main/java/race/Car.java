package race;

public class Car {

    private static final int CAR_NAME_LENGTH = 5;
    private static final int FORWARD_NUMBER = 4;

    private final String carName;
    private int position = 1;

    public Car(String carName) {
        if (carName.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("CarName is too long");
        }
        this.carName = carName;
    }

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public void forward(int randomNumber) {
        if (randomNumber >= FORWARD_NUMBER) {
            position++;
        }
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    public int compareWithMaxPosition(int maxPosition) {
        return Math.max(position, maxPosition);
    }

    public int getForwardResult() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
