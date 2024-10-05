package race;

public class Car {

    private static final int CAR_NAME_LENGTH = 5;
    private static final int FORWARD_NUMBER = 4;

    private final String carName;
    private Position position;

    public Car(String carName) {
        if (carName.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("CarName is too long");
        }
        this.carName = carName;
        this.position = new Position(1);
    }

    public Car(String carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public void forward(int randomNumber) {
        if (randomNumber >= FORWARD_NUMBER) {
            this.position = position.increase();
        }
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position.isMaxPosition(maxPosition);
    }

    public int compareWithMaxPosition(int maxPosition) {
        return this.position.compareWithMaxPosition(maxPosition);
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getCarName() {
        return carName;
    }
}
