package carracing.view;

import carracing.domain.record.CarRecord;
import carracing.domain.record.RoundRecord;
import carracing.domain.record.RoundRecords;

public class ResultView {

    public void showCarRacingResult(RoundRecords roundRecords) {
        System.out.println("\n실행 결과");
        for (RoundRecord roundRecord : roundRecords.getRoundRecords()) {
            showRoundResult(roundRecord);
        }
        showWinnerNames(roundRecords);
    }

    private void showRoundResult(RoundRecord roundRecord) {
        for (CarRecord carRecord : roundRecord.getCarRecords()) {
            System.out.printf("%-5s : %s%n", carRecord.getName(), "-".repeat(carRecord.getPosition()));
        }
        System.out.println();
    }

    private void showWinnerNames(RoundRecords roundRecords) {
        System.out.printf("%s가 최종 우승했습니다.", String.join(", ", roundRecords.findWinners()));
    }
}
