package step3;

public class Car {

    private int position;
    private MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        position = moveStrategy.move(position);
    }
}
