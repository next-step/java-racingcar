package car.domain.model;

public final class Car {

    private static final int MOVING_LIMIT = 4;
    private int position = 0;
    private final CarName carName;


    public Car(final String carName) {
        this.carName = new CarName(carName);
    }

    public void move(int randomNumber) {
        if (randomNumber < MOVING_LIMIT) return;

        position++;
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

}
