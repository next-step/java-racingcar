package step3;

import java.util.Arrays;

public class ResultView {

    private final String GAME_RESULT = "실행결과";
    private final String DASH = "-";

    public void printGameResult(Car[] cars) {
        Arrays.stream(cars).forEach(a -> printGameResult(a.getDistance()));
    }

    public void printGameResult(int result) {

        for(int i = 0; i < result; i++) {
            System.out.println(DASH);
        }

        System.out.println();
    }

    public void printGameResultText() {
        System.out.println(GAME_RESULT);
    }

    public void printNewLine() {
        System.out.println();
    }
}
