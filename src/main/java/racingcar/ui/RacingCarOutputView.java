package racingcar.ui;

import racingcar.domain.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarOutputView {

    private static final RacingCarOutputView OUTPUT_VIEW = new RacingCarOutputView();

    private static final String RACING_CAR_EMOJI = "\uD83D\uDE98";
    private static final String LINE_FEED = "\n";

    private RacingCarOutputView() {
    }

    public static RacingCarOutputView getInstance() {
        return OUTPUT_VIEW;
    }

    public void outputPrompt(Records records) {
        System.out.println("실행 결과");
        records.getValues().forEach((key, value) -> {
            System.out.println("Lap " + key.getValue());
            System.out.println(calculate(value) + LINE_FEED);
        });
        System.out.println(winner(records) + "가 최종 우승했습니다.");
    }

    public String calculate(Record record) {
        return record.getScores()
                .stream()
                .map(score -> String.format("%s: %s", score.getName().getValue(), repeat(RACING_CAR_EMOJI, score.getPosition().getValue())))
                .collect(Collectors.joining(LINE_FEED));
    }

    private String repeat(String str, int times) {
        return Stream.generate(() -> str).limit(times).collect(Collectors.joining());
    }

    public String winner(Records records) {
        Record record = records.getFinalRecord();

        return record.getWinner().stream()
                .map(Name::getValue)
                .collect(Collectors.joining(","));
    }
}
