package domain.cars;

public class Distance {
    static final int DEFAULT_DISTANCE = 0;
    private int distance;

    public Distance() {
        this((DEFAULT_DISTANCE));
    }
    public Distance(int distance) {
        if (distance < DEFAULT_DISTANCE) {
            throw new IllegalArgumentException("이동거리는 음수가 될 수 없습니다.");
        }
       this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public void move() {
        this.distance++;
    }

    public boolean isSameDistance(int distance) {
        return distance == this.distance;
    }
}
