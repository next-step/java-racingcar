package step3.view;

import step3.controller.RacingCarGame;

import java.util.List;

public class ResultView{

    private static final String ADVANCE = "-";

    public void print(RacingCarGame racingCarGame) {
        List<List<Integer>> list = racingCarGame.eachAttemptCarList();
        list.stream()
                .flatMap(List::stream)
                .map(ResultView::convertToStringOfAdvance)
                .forEach(System.out::println);
    }

    public static String convertToStringOfAdvance(int advance) {
        String resultAdvance = "";
        for (int i = 0; i < advance; i++) {
            resultAdvance += ADVANCE;
        }
        return resultAdvance;
    }

}
