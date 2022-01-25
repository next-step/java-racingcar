package racingcar.utils;

import racingcar.domain.Car;

public class OutputView {

    private static final String CAR_RACER_SPLITTER = " : ";
    private static final String CAR_MOVE_CHAR = "-";

    private OutputView() {}

    public static void printDistance(final Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.name() + CAR_RACER_SPLITTER);
        for (int index = 0; index < car.distance(); index++) {
            sb.append(CAR_MOVE_CHAR);
        }
        System.out.println(sb);
    }

    public static void printWhoIsWinner(final String winners) {
        System.out.print("최종 우승자 : " + winners);
    }

    public static void printTurnResult() {
        System.out.println("실행 결과");
    }
}
