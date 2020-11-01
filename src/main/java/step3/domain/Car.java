package step3.domain;

public class Car {

    private int position;

    public Car() {
        position = 0;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.move()) {
            position++;
        }

    }

    public int getCarPosition() {
        return this.position;
    }


}
