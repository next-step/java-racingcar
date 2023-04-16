package racingcar.ui;

import java.util.List;

public class ResultView {

    public static final int BEGIN_INDEX = 0;
    public static final char CAR_MOVE_STATE_LINE = '-';
    public static final String SEPARATOR = ", ";
    public static final int REMOVE_LAST_SEPARATOR_MIN = 2;

    public void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printWinners(List<String> carNames) {
        System.out.println(makeWinners(carNames) + "가 최종 우승했습니다.");
    }

    public void printQuestionCarCountMessage() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void printQuestionTryCountMessage() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public void printExecuteResultMessage() {
        System.out.println("실행 결과");
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printMoveStateLines(List<Integer> moveCounts) {
        for (int i = BEGIN_INDEX; i < moveCounts.size(); i++) {
            printMoveStateLine(moveCounts, i);
        }
        printNewLine();
    }

    private void printMoveStateLine(List<Integer> moveCounts, int idx) {
        System.out.println(makeCarMoveStateLine(moveCounts.get(idx)));
    }

    public String makeCarMoveStateLine(int moveCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = BEGIN_INDEX; i < moveCount; i++) {
            sb.append(CAR_MOVE_STATE_LINE);
        }
        return sb.toString();
    }


    private String makeWinners(List<String> carNames) {
        StringBuilder sb = new StringBuilder();
        for (String carName : carNames) {
            sb.append(carName).append(SEPARATOR);
        }

        if(carNames.size() >= REMOVE_LAST_SEPARATOR_MIN) {
            removeLastSeparator(sb);
        }
        return sb.toString();
    }

    private void removeLastSeparator(StringBuilder sb) {
        sb.setLength(sb.length() - SEPARATOR.length());
    }
}
