package racingcar.model;

public class Distance {
    private int distance;

    public Distance(int distance) {
        checkCarDistance(distance);
        this.distance = distance;
    }

    private void checkCarDistance(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("거리가 음수입니다.");
        }
    }

    public void forward() {
        this.distance++;
    }

    public int getDistance() {
        return this.distance;
    }
}
