package racingCar.domain;

public class Position  {
    private int cur = 0;

    public int getPosition() {
        return cur;
    }

    public void move() {
            this.cur++;
    }
}
