package domain;

public class Car {

    public static final int CAR_MOVE_CHECK = 4;
    public static final int CAR_ADVANCE = 1;
    public static final int CAR_STOP = 0;

    private CarDistance carDistance;

    public Car() {
        carDistance = new CarDistance();
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
}
