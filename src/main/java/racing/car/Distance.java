package racing.car;

import static racing.car.Car.MovementDistance.MOVEMENT_MAX_VALUE;
import static racing.car.Car.MovementDistance.MOVEMENT_MIN_VALUE;

public class Distance extends Location {
    private Distance(int distance) {
        super(distance);
    }

    public static Distance newInstance(int distance) {
        if (distance > MOVEMENT_MAX_VALUE.getValue())
            throw new IllegalArgumentException("최대 이동 가능한 거리는 " + MOVEMENT_MAX_VALUE + " 입니다.");
        if (distance < MOVEMENT_MIN_VALUE.getValue())
            distance = 0;
        return new Distance(distance);
    }
}
