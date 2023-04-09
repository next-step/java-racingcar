package study.step3.domain;

public class Car {

    private static final int STOP = 0;
    private int position;
    public int moveOrStop(int randomValue) {
        if (randomValue < 4) {
            return STOP;
        }
        return position += randomValue;
    }

    public int getPosition() {
        return position;
    }
}
