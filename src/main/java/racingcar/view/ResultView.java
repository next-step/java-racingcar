package racingcar.view;

import racingcar.racing.model.RacingRecord;

import java.util.List;

public class ResultView {

    private static final String DASH = "-";
    private static final String EMPTY = "";
    private static final StringBuilder strBuilder = new StringBuilder("\n\n실행 결과\n");


    public static void show(List<RacingRecord> recordList) {
        printHead();

        printBody(recordList);

        printFoot();
    }


    private static void printHead() {
        System.out.print(strBuilder.toString());
    }

    private static void printBody(List<RacingRecord> racingRecords) {
        for (RacingRecord record : racingRecords) {
            printDash(record);
        }
    }

    private static void printDash(RacingRecord racingRecord) {
        for (int i = 0; i < racingRecord.getCurPos(); i++) {
            System.out.print(DASH);
        }

        System.out.println(EMPTY);
    }

    private static void printFoot() {
        System.out.println(EMPTY);
    }
}
