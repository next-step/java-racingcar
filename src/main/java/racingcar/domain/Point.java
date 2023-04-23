package racingcar.domain;

public class Point {
    private final int point;
    public Point(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public Point increasePoint() {
        return new Point(this.point + 1);
    }
}
