package racingcar.ui;

import racingcar.racing.Racing;

import java.util.stream.IntStream;

public class OutputView {

    private static final String DISTANCE_UNIT = "-";

    public static void askCarNumbers() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void askRoundNumbers() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static void showRace(Racing racing, int numberOfRounds) {
        System.out.println("\n실행결과");

        IntStream.range(0, numberOfRounds).forEach(i -> {
            racing.start();
            System.out.println(racing);
        });
    }
}