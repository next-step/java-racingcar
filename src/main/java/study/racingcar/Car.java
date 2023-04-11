package study.racingcar;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private static final String MOVE_MARK = "-";

    private String position;

    public Car(String position) {
        this.position = position;
    }

    public void move(int randomNum) {
        if (isMove(randomNum)) {
            this.position += MOVE_MARK;
        }
    }

    private boolean isMove(int randomNum) {
        return randomNum >= MOVE_CONDITION;
    }

    public String getPosition() {
        return this.position;
    }
}
