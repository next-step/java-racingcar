package racingcargame;

import java.util.List;

public class ResultView {
    private static final String MOVING_LINE = "-";

    public void showResultView(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(car.showCarName() + " : " + convertDistanceToLine(car.showDistance()));
        }
        printNewLine();
    }

    public void printResultMessage() {
        System.out.println(System.lineSeparator() + "실행 결과");
    }

    public void printWinner(String winner) {
        removeLastComma(winner);
        System.out.println(winner.replaceAll(",$", "") + "가 최종 우승했습니다.");
    }

    private String convertDistanceToLine(int distance) {
        String line = "";
        for (int i = 0; i < distance; i++) {
            line += MOVING_LINE;
        }
        return line;
    }

    private void printNewLine() {
        System.out.print(System.lineSeparator());
    }

    private String removeLastComma(String winners) {
        return winners.replaceAll(", $", "");
    }
}
