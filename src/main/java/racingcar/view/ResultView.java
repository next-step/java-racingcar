package racingcar.view;

import racingcar.car.Position;

public class ResultView {

    private static StringBuilder statusSB = new StringBuilder();

    public static void printResultTitle() {
        System.out.println("\n실행 결과");
    }

    public static void printCarPositionStatus(Position position) {
        statusSB.setLength(0);

        for (int i = 0; i < position.getPosition(); i++) {
            statusSB.append("-");
        }

        System.out.println(statusSB);
    }
}
