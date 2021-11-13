package step4;

public class Car {

    private CarName carName;
    private int position;
    private MoveStrategy moveStrategy;

    public Car(String carName, MoveStrategy moveStrategy) {
        this.carName = new CarName(carName);
        this.moveStrategy = moveStrategy;
    }

    public int getPosition() {
        return position;
    }

    public CarName getName() {
        return carName;
    }

    public void move() {
        position = moveStrategy.move(position);
    }
}
