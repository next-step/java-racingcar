package racing.view;

import racing.domain.RoundRecord;

import java.util.List;

public class ResultView {

    private static final String GAME_RESULT = "실행 결과";
    public static void showResult(List<RoundRecord> records) {
        StringBuilder printResult = new StringBuilder();
        printResult.append(GAME_RESULT);
        for (RoundRecord roundRecord : records) {
            System.out.println(roundRecord.print());
        }
    }
}
