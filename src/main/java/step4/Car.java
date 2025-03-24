package step4;

public class Car {
    private int position;
    private final MoveCondition moveCondition;
    private final String carName;

    public Car(String carName, MoveCondition moveCondition) {
        this.position = 1;
        this.moveCondition = moveCondition;
        this.carName = carName;
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return  this.carName;
    }

    public void move() {
        if (!moveCondition.isMovable()) return;
        position++;
    }
}
