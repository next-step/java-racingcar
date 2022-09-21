package racingcar.view;

import racingcar.domain.RaceGame;

public class ResultView {

    public static final String RESULT_MESSAGE = "\n실행 결과";

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printGameStatus(RaceGame game) {
        game.getCars()
            .forEach(System.out::println);

        System.out.println();
    }
}
