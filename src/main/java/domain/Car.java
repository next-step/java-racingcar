package domain;

public class Car {

    public static final int CAR_MOVE_CHECK = 4;
    public static final int CAR_ADVANCE = 1;
    public static final int CAR_STOP = 0;

    private CarDistance carDistance;
    private CarName carName;

    public Car(String particapantName) {
        carDistance = new CarDistance();
        carName = new CarName(particapantName);
    }

    public void carMoveBehavior(int randomNumber) {

        if (randomNumber >= CAR_MOVE_CHECK) {
            move(()->CAR_ADVANCE);
        }

        if (randomNumber < CAR_MOVE_CHECK) {
            move(()->CAR_STOP);
        }

    }

    public void move(CarBehavior carBehavior) {
        carDistance.addCarDistance(carBehavior.carMove());
    }

    public int readCarDistance() {
        return carDistance.readCarDistance();
    }

    public String readParticipantName() {
        return carName.readCarName();
    }

}
