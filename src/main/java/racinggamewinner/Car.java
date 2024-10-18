package racinggamewinner;

public class Car {

    public static final int GO = 1;
    public static final int STOP = 0;
    public static final int MOVE_AVAILABLE_NUMBER = 4;
    private final CarName carName;
    private Position position;

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int positionNumber) {
        this.carName = new CarName(carName);
        position = new Position(positionNumber);
    }

    public int decideGoStop(int randomNumber) {
        if (randomNumber >= MOVE_AVAILABLE_NUMBER) {
            return GO;
        }
        return STOP;

    }

    public void updatePosition(int decisionResultNumber) {
        this.position.updatePosition(decisionResultNumber);
    }

    public int currentPosition() {
        return position.currentPosition();
    }

    public String carName() {
        return carName.carNameString();
    }

    public void checkNameLength() {
        carName.checkNameLength();
    }
}
