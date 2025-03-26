package step4.domain;

public class Car {
    private int position;
    private final MoveStrategy moveStrategy;
    private final String carName;

    public Car(String carName, MoveStrategy moveStrategy) {
        this.position = 1;
        this.moveStrategy = moveStrategy;
        this.carName = carName;
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return  this.carName;
    }

    public void move() {
        if (!moveStrategy.isMovable()) return;
        position++;
    }
}
