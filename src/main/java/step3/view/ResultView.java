package step3.view;

import step3.application.domain.model.MovementLog;
import step3.application.domain.model.OneMoveRecord;
import step3.application.domain.model.RacingHistory;

public class ResultView {

    public static final String LOCATION_MARK = "-";

    public void printRacingHistory(RacingHistory racingHistory) {
        System.out.println("\n실행 결과");
        racingHistory.getRacingRecords().forEach(this::printOneMoveRecord);
    }

    private void printOneMoveRecord(OneMoveRecord e) {
        e.getCarLocation().forEach(this::printLocation);
        System.out.println();
    }

    private void printLocation(MovementLog movementLog) {
        String currentLocation = LOCATION_MARK.repeat(Math.max(0, movementLog.getPosition()));
        System.out.println(String.format("%s : %s", movementLog.getName() ,currentLocation));
    }
}
