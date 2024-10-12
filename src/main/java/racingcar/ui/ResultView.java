package racingcar.ui;

import racingcar.domain.Record;
import racingcar.domain.Records;
import racingcar.domain.Winner;

import java.util.List;

public class ResultView {

    public static final String DASH = "-";
    public static final String EXECUTE_RESULT = "실행 결과";

    public static void printGameResult(List<Records> gameResult) {
        System.out.println(EXECUTE_RESULT);

        for (Records roundResult : gameResult) {
            printRoundRecords(roundResult);
            System.out.println();
        }
    }

    private static void printRoundRecords(Records records) {
        for (Record record : records.getRecords()) {
            printRoundRecordForOneCar(record);
            System.out.println();
        }
    }

    private static void printRoundRecordForOneCar(Record record) {
        System.out.print(record.getName() + " : ");
        System.out.print(DASH.repeat(record.getPosition()));
    }

    public static void printWinners(Winner winner) {
        String winnersName = String.join(", ", winner.getWinners());
        System.out.println(winnersName + "가 최종 우승했습니다.");
    }
}
