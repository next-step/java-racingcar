package carRacing.Domain;


public class Car implements Vehicle {
    int position;
    MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        this.position = 0;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.movable()) {
            position++;
        }
    }

    public int inquiryPosition() {
        return position;
    }
}
