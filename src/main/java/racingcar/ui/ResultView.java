package racingcar.ui;

import racingcar.Car;

import java.util.List;

public class ResultView {

    public static final int BEGIN_INDEX = 0;
    public static final char CAR_MOVE_STATE_LINE = '-';
    public static final String WINNERS_SEPARATOR = ", ";
    public static final String NAME_LINE_SEPARATOR = " : ";

    public void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printWinners(List<String> carNames) {
        System.out.println(makeWinners(carNames) + "가 최종 우승했습니다.");
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

    public void printCarNameAndMoveStateLines(List<Car> cars) {
    for (int i = BEGIN_INDEX; i < cars.size(); i++) {
            printCarNameAndMoveStateLine(cars, i);
        }
        printNewLine();
    }

    private void printCarNameAndMoveStateLine(List<Car> cars, int idx) {
        System.out.println(getCarName(cars, idx) + NAME_LINE_SEPARATOR + getCarMoveStateLine(cars, idx));
    }

    private String getCarName(List<Car> cars, int idx) {
        return cars.get(idx).name();
    }

    private String getCarMoveStateLine(List<Car> cars, int idx) {
        return makeCarMoveStateLine(cars.get(idx).moveCount());
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
            sb.append(carName).append(WINNERS_SEPARATOR);
        }
        removeLastSeparator(sb);

        return sb.toString();
    }

    private void removeLastSeparator(StringBuilder sb) {
        sb.setLength(sb.length() - WINNERS_SEPARATOR.length());
    }
}
