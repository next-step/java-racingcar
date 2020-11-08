package racing.domain;

import java.util.Random;

import static racing.domain.CarConfig.*;

public class RaceMovementRule implements RaceRule {

    private static final Random RANDOM = new Random();

    @Override
    public boolean movementRule() {
        return CAR_MIN_MOVE_CONDITION <= RANDOM.nextInt(CAR_MAX_RANDOM_NUMBER_SETTING);
    }
}
