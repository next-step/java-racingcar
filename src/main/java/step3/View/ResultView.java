package step3.View;

import step3.Common.ErrorMessageConstants;

import java.util.List;

public class ResultView {
    private static final String INIT_RESULT_PHRASE = "실행 결과";
    private static final String CAR_POSITION_UNIT = "-";

    private ResultView() {
        throw new AssertionError(ErrorMessageConstants.CONSTRUCTOR_ERROR_MESSAGE);
    }

    public static void viewResultPhrase() {
        System.out.println(INIT_RESULT_PHRASE);
    }

    public static void viewPositions(List<Integer> positions) {
        for (Integer position : positions) {
            viewPosition(position);
        }
        System.out.println();
    }

    private static void viewPosition(int position) {
        System.out.println(makeHypens(position));
    }

    private static String makeHypens(int count) {
        return CAR_POSITION_UNIT.repeat(count);
    }
}
