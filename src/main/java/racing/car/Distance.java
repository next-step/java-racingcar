package racing.car;

import static racing.car.DistanceRange.NOT_MOVEMENT;

public class Distance extends Location {
    private Distance(int distance) {
        super(distance);
    }

    public static Distance newInstance(int distance) {
        DistanceRange range = validate(distance);
        return new Distance(
                range == NOT_MOVEMENT ? 0 : distance
        );
    }

    private static DistanceRange validate(int distance) {
        DistanceRange range = DistanceRange.of(distance);
        switch (range) {
            case BACK_MOVEMENT:
                throw new IllegalArgumentException("후진할 수 없습니다.");
            case MAX_MOVEMENT:
                throw new IllegalArgumentException("최대 이동 가능한 거리를 초과 했습니다.");
        }
        return range;
    }
}
