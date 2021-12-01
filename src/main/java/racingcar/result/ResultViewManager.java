package racingcar.result;

import racingcar.common.util.OutputUtils;
import racingcar.racing.RacingManager;

public class ResultViewManager {
    private final RacingManager racingManager;

    public ResultViewManager(RacingManager racingManager) {
        this.racingManager = racingManager;
    }

    public void drawingCars() {
        System.out.println("실행 결과");
        racingManager.getResultInfos().forEach(resultInfo -> {
            resultInfo.getResults().forEach(result -> System.out.println(OutputUtils.convertLiteral(result)));
            System.out.println();
        });
    }
}
