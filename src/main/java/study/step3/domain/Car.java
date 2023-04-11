package study.step3.domain;

public class Car {

    public static final int GO = 1;
    private int position;

    public void moveForward(int randomValue) {
        if (randomValue >= 4) {
            position += GO;
        }
    }

    public int getPosition() {
        return position;
    }
}
