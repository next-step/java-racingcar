package RacingGame.view;

import RacingGame.common.ErrorMessageConstants;
import RacingGame.model.Record;

public class ResultView {
    private static final String INIT_RESULT_PHRASE = "실행 결과";

    private ResultView() {
        throw new AssertionError(ErrorMessageConstants.CONSTRUCTOR_ERROR_MESSAGE.getMessage());
    }

    public static void viewResultPhrase() {
        System.out.println(INIT_RESULT_PHRASE);
    }

    public static void viewResult(Record record) {
        System.out.println(record.getRecord());
    }


}
