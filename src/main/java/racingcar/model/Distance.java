package racingcar.model;

public class Distance {
    private int distance;

    public Distance(int distance) {
        checkCarDistance(distance);
        this.distance = distance;
    }

    private void checkCarDistance(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("거리가 0보다 커야합니다.");
        }
    }

    public void forward() {
        this.distance++;
    }

    public int getDistance() {
        return this.distance;
    }
}
