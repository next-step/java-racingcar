package racingcar.domain;

public class Distance {
    private int distance;

    public Distance(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("거리는 음수를 입력할 수 없습니다.");
        }
        this.distance = distance;
    }

    public Distance() {
        this(0);
    }

    public void move() {
        distance++;
    }

    public boolean isEqualTo(int distance) {
        return this.distance == distance;
    }

    public int getDistance() {
        return distance;
    }
}
