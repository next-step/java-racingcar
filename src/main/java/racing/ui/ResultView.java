package racing.ui;

import racing.dto.GameResult;
import racing.dto.GameResult.GameRoundResult;
import racing.utils.Counter;

import java.util.List;
import java.util.Objects;
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
        Objects.requireNonNull(result);
        System.out.println();
        System.out.println(PRINT_RESULT_MESSAGE);
        result.getRounds().forEach(this::printRoundResult);
        List<String> winners = result.getWinners();
        String joinWinners = String.join(",", winners);
        System.out.println(joinWinners + "가 최종 우승했습니다.");
    }

    private void printRoundResult(GameRoundResult round) {
        round.getCarStatus().forEach(this::printMark);
        System.out.println();
    }

    private void printMark(String name, Counter status) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(" : ");
        IntStream.range(0, status.getCount())
                .mapToObj(i -> DISPLAY_MARK)
                .forEach(stringBuilder::append);
        System.out.println(stringBuilder);
    }
}
