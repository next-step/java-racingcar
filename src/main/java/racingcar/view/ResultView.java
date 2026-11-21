package racingcar.view;

import racingcar.domain.CarStatus;
import racingcar.domain.RoundResult;

import java.util.List;

public class ResultView {
    private static final String NAME_POSITION_DELIMITER = " : ";

    private ResultView() {
    }

    public static void showResult(List<RoundResult> roundResults) {
        System.out.println();
        System.out.println("실행 결과");

        showRoundResults(roundResults);
    }

    private static void showRoundResults(List<RoundResult> roundResults) {
        for (RoundResult roundResult : roundResults) {
            showCarPositions(roundResult.carStatuses());
            System.out.println();
        }
    }

    private static void showCarPositions(List<CarStatus> carStatuses) {
        for (CarStatus carStatus : carStatuses) {
            System.out.println(carStatus.name() + NAME_POSITION_DELIMITER + PositionFormatter.format(carStatus.position()));
        }
    }
}
