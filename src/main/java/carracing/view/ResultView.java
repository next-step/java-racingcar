package carracing.view;

import carracing.domain.Car;
import carracing.domain.record.RoundRecord;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void showCarRacingResult(List<RoundRecord> roundRecords) {
        System.out.println("\n실행 결과");

        for (RoundRecord roundRecord : roundRecords) {
            showRoundResult(roundRecord);
        }

        showWinnerNames(roundRecords);
    }

    private void showRoundResult(RoundRecord roundRecord) {
        for (Car carRecord : roundRecord.getCars()) {
            System.out.printf("%-5s : %s%n", carRecord.getName(), "-".repeat(carRecord.getPosition()));
        }

        System.out.println();
    }

    private void showWinnerNames(List<RoundRecord> roundRecords) {
        RoundRecord lastRound = getLastRoundRecord(roundRecords);
        List<String> winnerNames = getLeadingCarNames(lastRound);
        System.out.printf("%s가 최종 우승했습니다.", String.join(", ", winnerNames));
    }

    private RoundRecord getLastRoundRecord(List<RoundRecord> roundRecords) {
        return roundRecords.get(roundRecords.size() - 1);
    }

    private static List<String> getLeadingCarNames(RoundRecord roundRecord) {
        return roundRecord.getLeadingCar()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
