package CarRacing;

public class Car {

    private Position position;
    private CarName carName;

    public Car(CarName carName) {
        this.position = new Position();
        this.carName = carName;
    }

    public void move(MovigStrategy movigStrategy) {

        if (movigStrategy.moveAble()) {
            position.increasePosition();

        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public Boolean isSamePostion(Car other) {
        return this.getPosition() == other.getPosition();
    }


}
