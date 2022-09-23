package view;

import domain.RacingScore;

import java.util.List;
import java.util.Map;

public class ResultView {

    private ResultView() {}

    public static void resultTitle() {

        System.out.println("실행 결과");
    }

    public static void resultPrint(final RacingScore racingScore) {

        totalResultPrint(racingScore.score());
    }

    private static void totalResultPrint(final Map<Integer, List<String>> score) {

        for (Integer integer : score.keySet()) {
            roundPrint(score.get(integer));
            ResultView.blank();
        }
    }

    private static void roundPrint(final List<String> strings) {

        strings.stream()
                .forEach(System.out::println);
    }

    private static void blank() {

        System.out.println();
    }
}
