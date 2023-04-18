package study.racingcar;

public class Car {
    private String name;
    private int position;
    private MoveStrategy moveStrategy;

    public Car(int position, String name, MoveStrategy moveStrategy) {
        this.position = position;
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public int currentPosition() {
        return this.position;
    }

    public void move() {

        if (moveStrategy.isMove()) {
            this.position = position + 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public boolean isPosition(int maxPosition) {

        return this.position == maxPosition;
    }

}
