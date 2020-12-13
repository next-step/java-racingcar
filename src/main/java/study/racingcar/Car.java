package study.racingcar;

public class Car {

    private static final int FORWARD_NUM = 4;
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int randomNo) {
        if (FORWARD_NUM <= randomNo) {
            advanced();
        }
    }

    public void advanced() {
        this.position += 1;
    }

    public int getPosition() {
        return position;
    }

}
