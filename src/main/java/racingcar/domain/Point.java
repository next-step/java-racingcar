package racingcar.domain;

public class Point {
    private int point = 0;
    public Point(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void plusPoint() {
        point++;
    }
}
