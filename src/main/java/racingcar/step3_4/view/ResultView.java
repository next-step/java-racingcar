package racingcar.step3_4.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.step3_4.domain.GameRecord;
import racingcar.step3_4.domain.Name;
import racingcar.step3_4.domain.TryRecord;
import racingcar.step3_4.domain.TryResult;
import racingcar.step3_4.domain.Winners;

public class ResultView {

    private static final char DASH_MARK = '-';

    public void printGameResult(GameRecord gameRecord) {
        printEachTryResult(gameRecord.getTryResults());
        printWinners(gameRecord.getWinners());
    }

    private void printEachTryResult(List<TryResult> tryResults) {
        for (TryResult tryResult : tryResults) {
            printRecords(tryResult.getRecords());
        }
    }

    private void printRecords(List<TryRecord> records) {
        StringBuilder stringBuilder = new StringBuilder();
        for (TryRecord tryRecord : records) {
            stringBuilder.append(tryRecord.getName());
            stringBuilder.append(" : ");
            stringBuilder.append(toDashMark(tryRecord.getPosition()));
        }
        System.out.println(stringBuilder);
    }

    private void printWinners(Winners winners) {
        System.out.println(getNames(winners) + "가 최종 우승했습니다.");
    }

    private String toDashMark(int carPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            stringBuilder.append(DASH_MARK);
        }
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    private String getNames(Winners winners) {
        return winners.getNames()
            .stream()
            .map(Name::toString)
            .collect(Collectors.joining(", "));
    }
}
