package racingcargame;

import java.util.List;

public class ResultView {
    private static final String MOVING_LINE = "-";

    public void showResultView(List<RacingCar> cars) {
       for (RacingCar car : cars) {
           System.out.println(convertDistanceToLine(car.getDistance()));
       }
       printNewLine();
    }

    public void printResultMessage() {
        System.out.println(System.lineSeparator() + "실행 결과");
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
}
