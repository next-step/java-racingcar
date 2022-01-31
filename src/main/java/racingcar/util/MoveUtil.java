package racingcar.util;

import java.util.List;
import racingcar.domain.RacingCar;

public class MoveUtil {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;

    public static String moveForwardAll(List<RacingCar> racingCarLists) {
        StringBuilder racingStatus = new StringBuilder();
        for (RacingCar racingCar : racingCarLists) {
            racingCar.moveForward(RandomUtil.pickNumberInRange(RANDOM_START, RANDOM_END));
            racingStatus.append(racingCar.getName() + ":" + racingCar.getPosition() + "\n");
        }
        racingStatus.append("----------------\n");
        return racingStatus.toString();
    }

}
