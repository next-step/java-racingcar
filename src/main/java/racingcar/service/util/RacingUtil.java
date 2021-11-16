package racingcar.service.util;

import racingcar.domain.RacingCar;

import java.util.List;
import java.util.Random;

public class RacingUtil {

    private static final Random random = new Random();

    public static int getRandomValue(int value) {

        return random.nextInt(value);
    }

}
