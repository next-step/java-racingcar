package racingcar.view;

import racingcar.racing.RacingGame;
import racingcar.racing.RacingRecord;

import java.util.List;

public class ResultView {

    private static final String DASH = "-";
    private static final String EMPTY = "";
    private static final StringBuilder strBuilder = new StringBuilder("\n\n실행 결과\n");


    public static void show(int tryNumber, RacingGame racingGame) {
        printHead();

        for (int i = 0; i < tryNumber; i++) {
            printBody(racingGame.getResult(i));
        }

    }

    private static void printHead() {
        System.out.print(strBuilder.toString());
    }

    private static void printBody(List<RacingRecord> racingRecords) {
        for (RacingRecord record : racingRecords) {
            printDash(record);
        }

        printFoot();
    }

    private static void printFoot() {
        System.out.println(EMPTY);
    }


    private static void printDash(RacingRecord racingRecord) {
        for (int i = 0; i < racingRecord.getCurPos(); i++) {
            System.out.print(DASH);
        }

        System.out.println(EMPTY);
    }
}
