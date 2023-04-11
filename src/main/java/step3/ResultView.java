package step3;

import java.util.List;

public class ResultView {

    public static void printGameResult(RacingGameResult racingGameResult) {
        List<Integer> positions = racingGameResult.getCarPositions();
        System.out.println("실행 결과");
        positions.forEach(ResultView::printPosition);
    }

    public static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printError(String message) {
        System.out.println("## Error 발생 ##");
        System.out.println("## " + message + " ##");
    }
}
