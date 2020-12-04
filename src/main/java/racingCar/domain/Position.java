package racingCar.domain;

public class Position {
    private static final int INITIAL_POSITION = 0;

    private int cur;

    public Position() {
        cur = INITIAL_POSITION;
    }

    public int getPosition() {
        return cur;
    }

    public void move(int condition) {
        if (condition >= 4 && condition <= 9) {
            this.cur++;
        }
    }
}
