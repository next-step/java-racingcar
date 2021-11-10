package racingStep3.service.util;

import racingStep3.domain.RacingCar;

import java.util.List;
import java.util.Random;

public class RacingUtil {

    private static final Random random = new Random();
    private static MoveRuleUtil moveRule = new MoveRuleUtil();

    public static void playTheGame(List<RacingCar> cars) {
        for(RacingCar car : cars) {
            car.decisionMove(moveRule.moveOrNot());
        }
    }

    public static int getRandomValue(int value) {

        return random.nextInt(value);
    }

}
