package car;

public class Car {
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(MoveStrategy moveStrategy) {
        if(moveStrategy.movable()) {
            position++;
        }
    }
}
