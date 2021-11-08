package racingStep3.service;

import racingStep3.domain.RacingCar;

import java.util.List;
import java.util.Random;

public class RacingUtil {

    private static final Integer MAX_RANDOM = 9;

    public static void playTheGame(List<RacingCar> cars) {
        for(RacingCar car : cars) {
            car.moveOrNot(getRandomValue());
        }
    }

    public static int getRandomValue() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM);
    }

}
