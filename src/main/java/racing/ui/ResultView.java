package racing.ui;

import racing.dto.GameResult;
import racing.dto.GameResult.GameRoundResult;
import racing.utils.Counter;

import java.util.stream.IntStream;

public class ResultView {
    private static final String PRINT_RESULT_MESSAGE = "실행 결과";
    private static final String DISPLAY_MARK = "-";
    private static ResultView instance;

    private ResultView() {
    }

    public static ResultView getInstance() {
        if (instance == null) {
            instance = new ResultView();
        }
        return instance;
    }

    public void printResult(GameResult result) {
        System.out.println();
        System.out.println(PRINT_RESULT_MESSAGE);
        result.getRounds().forEach(this::printRoundResult);
    }

    private void printRoundResult(GameRoundResult round) {
        round.getStatusList().forEach(status -> {
            printMark(status);
            System.out.println();
        });
        System.out.println();
    }

    private void printMark(Counter status) {
        IntStream.range(0, status.getCount()).mapToObj(i -> DISPLAY_MARK).forEach(System.out::print);
    }
}
