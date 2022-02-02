package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.util.Movable;
import racingcar.util.RandomUtil;

public class ResultView implements Movable {

    private static final int GAME_COUNT_LAST = 0;
    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final String CONTOUR = "----------------\n";

    public String getGameStatus(int raceCount, List<RacingCar> racingCarLists) {
        StringBuilder currentResult = new StringBuilder();
        while (raceCount > GAME_COUNT_LAST) {
            currentResult.append(moveForwardAll(racingCarLists));
            raceCount--;
        }
        return currentResult.toString();
    }

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
