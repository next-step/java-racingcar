package racingcar.view;

import racingcar.model.CarMoveDistance;
import racingcar.model.Identity;
import racingcar.model.PositiveNumber;

import java.util.Map;

public class OutputView {
    private OutputView() {
    }

    private static final String RESULT_GUIDE = "실행 결과";

    public static void guide() {
        System.out.println(RESULT_GUIDE);
    }

    public static void racingResult(PositiveNumber trialStep, Map<Identity, CarMoveDistance> carMoveDistanceMap) {
        for (Identity identity : carMoveDistanceMap.keySet()) {
            PositiveNumber distanceEachStep = carMoveDistanceMap.get(identity)
                    .getMoveDistanceTrace()
                    .get(trialStep.getNumber());
            System.out.println(oneDistance().repeat(distanceEachStep.getNumber()));
        }
        endLine();
    }

    private static String oneDistance() {
        return "-";
    }

    private static void endLine() {
        System.out.println();
    }
}
