package racingCar.domain;

public class Position implements Comparable<Position> {
    private int cur = 0;

    public int getPosition() {
        return cur;
    }

    public void move() {
            this.cur++;
    }

    @Override
    public int compareTo(Position o) {
        if(this.cur == o.cur) {
            return 0;
        }
        if(this.cur < o.cur) {
            return -1;
        }
        return 1;
    }
}
