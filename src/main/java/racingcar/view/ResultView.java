package racingcar.view;

import racingcar.Result;

public class ResultView {
    private static final String MOVE_COUNT_VIEW = "-";

    public static void print(Result result) {
        for (int i = 0; i < result.getCarLocation().size(); i++) {
            makeLocationView(result, i);
        }
        System.out.println();
    }

    private static void makeLocationView(Result result, int idx) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int j=0; j<result.getCarLocation().get(idx); j++) {
            stringBuilder.append(MOVE_COUNT_VIEW);
        }
        System.out.println(stringBuilder);
    }
}