package racingcar.view;

import racingcar.MidScore;

import java.util.Collections;
import java.util.List;

public class ResultView {

    private static final String CAR_RACING_FIGURE = "-";

    public static void printResultView(List<MidScore> midScoreList) {
        System.out.println("실행 결과");

        midScoreList.forEach(ResultView::printScore);
    }

    private static void printScore(MidScore roadMap) {

        roadMap.getScores()
                .stream()
                .map(cnt -> String.join("", Collections.nCopies(cnt, CAR_RACING_FIGURE)))
                .forEach(System.out::println);

        System.out.println("\n");
    }
}
