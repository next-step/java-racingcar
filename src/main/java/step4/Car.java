package step4;

public class Car {
    private final CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public Car() {
        this.carName = new CarName("name");
        this.position = 0;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.canMove()) {
            position++;
        }
    }

    int getPosition() {
        return this.position;
    }

    String getName() {
        return this.carName.getCarName();
    }

    public StringBuilder getCurrentStatus() {
        return new StringBuilder()
                .append(carName.getCarName())
                .append(" : ")
                .append("-".repeat(position));
    }
}
