package step3.domain;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 1;
    }

    public void moveOrStop(MovableStrategy movableStrategy) {
        if (movableStrategy.isMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
