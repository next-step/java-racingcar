package racing.car;

import static racing.car.DistanceRange.NOT_MOVEMENT;

public class Distance extends Location {
    private final DistanceRange distanceRange;
    private Distance(int distance, DistanceRange range) {
        super(range == NOT_MOVEMENT ? 0 : distance);
        this.distanceRange = range;
    }

    public static Distance newInstance(int distance) {
        DistanceRange range = DistanceRange.of(distance);
        validate(range);
        return new Distance(distance, range);
    }

    private static void validate(DistanceRange range) {
        switch (range) {
            case BACK_MOVEMENT:
                throw new IllegalArgumentException("후진할 수 없습니다.");
            case LIMIT_MOVEMENT:
                throw new IllegalArgumentException("최대 이동 가능한 거리를 초과 했습니다.");
        }
    }

    public DistanceRange getDistanceRange() {
        return distanceRange;
    }
}
