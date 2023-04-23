package racingcar.domain;

public class Point {
    private int point;
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
