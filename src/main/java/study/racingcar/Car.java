package study.racingcar;

public class Car implements MoveStrategy{
    private static final int MOVE_CONDITION = 4;

    private String name;
    private int position;

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
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

    @Override
    public boolean isMove(int number) {
        return number >= MOVE_CONDITION;
    }
}
