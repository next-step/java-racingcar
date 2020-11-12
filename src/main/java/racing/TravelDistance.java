package racing;

public class TravelDistance {

    private final int travelDistance;

    public TravelDistance() {
        this(0);
    }

    public TravelDistance(int travelDistance) {
        if (travelDistance < 0) {
            throw new IllegalArgumentException("이동거리는 0 보다 작을 수 없습니다.");
        }
        this.travelDistance = travelDistance;
    }

    public TravelDistance move() {
        return new TravelDistance(travelDistance + 1);
    }

    public int getTravelDistance() {
        return travelDistance;
    }
}
