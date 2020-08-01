package step3.output;

import step3.service.CarRacingGame;

import java.util.List;

public class ResultView {

    private static final Character MARK = '-';

    public static void printResult() {
        System.out.println("실행 결과");
        CarRacingGame.scoreboard.forEach(ResultView::printPositions);
    }

    private static void printPositions(List<Integer> positions) {
        positions.forEach(ResultView::printPositionOfAttempt);
        System.out.println();
    }

    private static void printPositionOfAttempt(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(MARK);
        }
        System.out.println(builder.toString());
    }

}
