package step4.view;

import step4.dto.RaceRecordGroup;
import step4.dto.RaceRecord;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_RESULT_MESSAGE = "%s가 우승했습니다";
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final String COLON = ":";
    private static final String SKID_MARK = "-";
    private static final int ZERO = 0;

    private ResultView() {}

    private static class ResultViewHolder {
        private static ResultView INSTANCE = new ResultView();
    }

    public static ResultView getInstance() {
        return ResultViewHolder.INSTANCE;
    }

    public void renderRaceRecords(RaceRecordGroup raceRecordGroup) {
        System.out.println(RESULT_MESSAGE);

        raceRecordGroup.getRaceRecordGroup()
                .forEach((record) -> {
                    processRaceRecord(record);
                });

        System.out.println(STRING_BUILDER);
    }

    public void renderRaceWinners(RaceRecordGroup raceRecordGroup, String delimiter) {
        STRING_BUILDER.setLength(ZERO);

        String winnerNames = raceRecordGroup.findWinners().stream().map(name -> name.getName()).collect(Collectors.joining(delimiter));

        System.out.printf(WINNER_RESULT_MESSAGE, winnerNames);
    }

    private void processRaceRecord(RaceRecord raceRecord) {

        raceRecord.getRaceRecord().forEach((car) -> {
                    STRING_BUILDER.append(car.getName().getName()).append(COLON);
                    createSkidMark(car.getPosition().getPosition());
                });

        STRING_BUILDER.append(System.lineSeparator());
    }

    private void createSkidMark(int count) {
        for(int i = 0 ; i < count ; ++i) {
            STRING_BUILDER.append(SKID_MARK);
        }

        STRING_BUILDER.append(System.lineSeparator());
    }
}
