package racing.ui;

import racing.domain.Position;
import racing.domain.RacingHistories;
import racing.domain.RoundHistory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String PRINT_RESULT_MESSAGE = "실행 결과";
    private static final String DISPLAY_MARK = "-";
    private static final String WINNER_JOIN_DELIMITER = ",";
    private static final String DISPLAY_COLON = " : ";
    private static final String WINNER_PRINT_FORMAT = "%s 가 최종 우승했습니다.%n";
    private static final int BUILDER_LENGTH = 0;
    private static ResultView instance;
    private final StringBuilder stringBuilder = new StringBuilder();

    public static ResultView getInstance() {
        if (instance == null) {
            instance = new ResultView();
        }
        return instance;
    }

    public void showProgress(RacingHistories racingHistories) {
        Objects.requireNonNull(racingHistories);

        stringBuilder.setLength(BUILDER_LENGTH);
        stringBuilder.append(System.lineSeparator());

        stringBuilder.append(PRINT_RESULT_MESSAGE);
        stringBuilder.append(System.lineSeparator());

        List<RoundHistory> roundHistories = racingHistories.getRoundHistories();
        roundHistories.forEach(this::appendRoundHistory);

        System.out.print(stringBuilder);
    }

    private void appendRoundHistory(RoundHistory roundHistory) {
        roundHistory.getCarPositions().forEach(this::appendCarPositions);
        stringBuilder.append(System.lineSeparator());
    }

    private void appendCarPositions(String name, Position value) {
        int position = value.getCurrentPosition();
        stringBuilder.append(name);
        stringBuilder.append(DISPLAY_COLON);
        String displayPosition = getSkidMark(position);
        stringBuilder.append(displayPosition);
        stringBuilder.append(System.lineSeparator());
    }

    private String getSkidMark(int position) {
        return IntStream.range(0, position)
                .mapToObj(i -> DISPLAY_MARK)
                .collect(Collectors.joining());
    }

    public void showWinner(List<String> winner) {
        if (winner == null || winner.isEmpty()) {
            return;
        }

        String joinWinners = String.join(WINNER_JOIN_DELIMITER, winner);
        stringBuilder.setLength(0);
        stringBuilder.append(String.format(WINNER_PRINT_FORMAT, joinWinners));
        System.out.print(stringBuilder);
    }
}
