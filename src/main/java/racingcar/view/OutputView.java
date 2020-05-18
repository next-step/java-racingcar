package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String TEXT_TITLE = "\n실행결과";

    private OutputView() {

    }

    public static void printTitle() {
        System.out.println(TEXT_TITLE);
    }

    public static void printRaceResult(List<Integer> raceResults) {
        for (int position : raceResults) {
            draw(position);
        }
        System.out.println();

    }

    private static void draw(int position) {
        for (int i = 0 ; i < position ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
