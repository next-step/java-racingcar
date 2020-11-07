package racing.domain;

import java.util.Random;

import static racing.domain.CarConfig.*;

public class CarThrottleSensor {

    private final Random random = new Random();

    public boolean check() {
        return CAR_MIN_MOVE_CONDITION <= random.nextInt(CAR_MAX_RANDOM_NUMBER_SETTING);
    }
}
