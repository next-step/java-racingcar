package racingcar.ui;

import racingcar.domain.Record;
import racingcar.domain.Records;

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
    }

    public String calculate(Record record) {
        return record.getPositions()
                .stream()
                .map(position -> repeat(RACING_CAR_EMOJI, position.getValue()))
                .collect(Collectors.joining(LINE_FEED));
    }

    private String repeat(String str, int times) {
        return Stream.generate(() -> str).limit(times).collect(Collectors.joining());
    }
}
