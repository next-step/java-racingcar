package racingcar.view;

import racingcar.racing.model.RacingRecord;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ResultView {

    private static final String DASH = "-";
    private static final String EMPTY = "";
    private static final String HEAD = "\n\n실행 결과\n";
    private static final String COMMA = ", ";
    private static final String WINNER_COMMENT = "가 최종 우승했습니다.\n";
    private static final String NAME_DELIMITER = " : ";

    private static StringBuilder strBuilder;



    public static void show(List<RacingRecord> recordList, boolean first) {

        printBody(recordList);

        printFoot();
    }


    private static void printHead(boolean first) {
        if(first) {
            strBuilder = new StringBuilder(HEAD);
            System.out.print(strBuilder.toString());
        }

    }

    private static void printBody(List<RacingRecord> racingRecords) {
        for (RacingRecord record : racingRecords) {
            printParticipantName(record.getParticipantName());
            printDash(record.getCurPos());
        }
    }

    private static void printParticipantName(String name) {
        strBuilder = new StringBuilder(name);
        strBuilder.append(NAME_DELIMITER);
        System.out.print(strBuilder.toString());
    }

    private static void printDash(int curPos) {
        for (int i = 0; i < curPos; i++) {
            System.out.print(DASH);
        }
        System.out.println(EMPTY);
    }

    private static void printFoot() {
        System.out.println(EMPTY);
    }

    public static void printWinners(List<String> winnerList) {
        strBuilder = new StringBuilder("\n");

        for(int i = 0; i < winnerList.size(); i++) {
            strBuilder.append(winnerList.get(i));
            addComma(i, winnerList.size() - 1);
        }

        strBuilder.append(WINNER_COMMENT);

        System.out.println(strBuilder.toString());
    }

    private static void addComma(int idx, int lastIdx) {
        if(idx != lastIdx) {
            strBuilder.append(COMMA);
        }
    }
}
