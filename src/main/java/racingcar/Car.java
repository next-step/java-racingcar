package racingcar;

public class Car {
    private int position = 0;

    public boolean canRun(int randomNum) {
        if (randomNum >= 4) {
            return true;
        }
        return false;
    }

    public void move(boolean canRun) {

    }

    public int getPosition() {
        return position;
    }
}
