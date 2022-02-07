package racingcar.domain;

import java.util.List;
import racingcar.util.Movable;
import racingcar.util.RandomUtil;

public class GameStatus implements Movable {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final String CONTOUR = "----------------\n";

    @Override
    public String moveForwardAll(List<RacingCar> racingCarLists) {
        StringBuilder racingStatus = new StringBuilder();
        for (RacingCar racingCar : racingCarLists) {
            racingCar.moveForward(RandomUtil.pickNumberInRange(RANDOM_START, RANDOM_END));
            racingStatus.append(racingCar.getName() + ":" + racingCar.getPosition() + "\n");
        }
        racingStatus.append(CONTOUR);
        return racingStatus.toString();
    }
}
