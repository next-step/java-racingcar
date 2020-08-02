package racingcar.ui;

import racingcar.Car;

public class ResultView {

    private final static char MOVE_MARK = '-';

    public static void printStart() {
        System.out.println("실행 결과");
    }

    public static void printResult(Car car) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getMoveCount() + 1; i++) {
            sb.append(MOVE_MARK);
        }
        System.out.println(sb.toString());
    }

    public static void lineFeed() {
        System.out.println();
    }
}
