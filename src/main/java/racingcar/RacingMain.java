package racingcar;

import racingcar.common.util.InputUtils;
import racingcar.racing.RacingInfo;
import racingcar.racing.RacingManager;

public class RacingMain {
    public static void main(String[] args) {
        RacingInfo racingInfo = new RacingInfo(
                InputUtils.getIntValue("자동차 대수는 몇 대 인가요?"),
                InputUtils.getIntValue("시도할 회수는 몇 회 인가요?")
        );
        RacingManager racingManager = new RacingManager(racingInfo);
        racingManager.startRace();
    }
}
