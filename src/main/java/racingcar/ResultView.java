package racingcar;

import java.util.List;

public class ResultView {
    public static final int BEGIN_INDEX = 0;
    public static final char CAR_MOVE_STATE_LINE = '-';

    public void questionCarCountMessage() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void questionTryCountMessage() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public void executeResultMessage() {
        System.out.println("실행 결과");
    }

    public void printNewLine() {
        System.out.println();
    }

    public String getCarMoveStateLine(int moveCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = BEGIN_INDEX; i < moveCount; i++) {
            sb.append(CAR_MOVE_STATE_LINE);
        }
        return sb.toString();
    }

    public void printMoveStateLines(List<Integer> moveCounts, int carCount) {
        for (int i = BEGIN_INDEX; i < carCount; i++) {
            printMoveStateLine(moveCounts, i);
        }
    }

    private void printMoveStateLine(List<Integer> moveCounts, int idx) {
        System.out.println(getCarMoveStateLine(moveCounts.get(idx)));
    }
}
