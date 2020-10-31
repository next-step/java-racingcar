package step4.domain;

public class Car {

    private int position;
    private String name;

    public Car(String name) {
        this.name = name;
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
