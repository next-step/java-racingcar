package study.racingcar;

public class Car extends Moving {
    private String name;
    private int position;

    public Car(int position, String name, MoveStrategy moveStrategy) {
        this.position = position;
        this.name = name;

        setMoveStrategy(moveStrategy);
    }

    public int currentPosition() {
        return this.position;
    }

    public void move(int number) {

        if (isMove(number)) {
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
