package racingcar.view;

import racingcar.RacingRecord;

public class ResultView {
    public static void printRoundRecord(RacingRecord roundRecord, String shape) {
        printStartMessage();
        print(roundRecord.printRecordWithSymbol(shape));
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void printNewLine() {
        System.out.println();
    }

    private static void printStartMessage() {
        System.out.println("실행 결과");
    }
}
