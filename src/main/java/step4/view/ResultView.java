package step4.view;

import step4.common.MyNumber;
import step4.dto.name.CarNameGroup;
import step4.dto.record.Record;
import step4.dto.record.RecordGroup;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static final ResultView INSTANCE = new ResultView();
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    public static final String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String ASK_TRIAL_COUNT = "시도할 회수는 몇회인가요?";
    public static final String RACING_RESULT = "실행 결과";
    public static final String PRINT_WINNER = "%s가 최종 우승했습니다.";

    public static final String COLON = " : ";
    public static final String SKID_MARK = "-";

    private ResultView() {}

    public static ResultView getInstance() {
        return INSTANCE;
    }

    public void println(String text) {
        System.out.println(text);
    }

    public void renderRaceRecord(List<RecordGroup> recordGroups) {
        STRING_BUILDER.setLength(MyNumber.ZERO.getValue());

        println(RACING_RESULT);

        recordGroups.stream()
                .forEach(record -> createRecordView(record));

        System.out.println(STRING_BUILDER);
    }

    public void renderWinner(CarNameGroup winner, String delimiter) {
        STRING_BUILDER.setLength(MyNumber.ZERO.getValue());

        String names = winner.getCarNameGroup().stream()
                .collect(Collectors.joining(delimiter));

        System.out.printf(PRINT_WINNER, names);
    }

    private void createRecordView(RecordGroup recordGroup) {
        recordGroup.getRecords().stream()
                .forEach(record -> {
                    appendSkidMark(record);
                });

        STRING_BUILDER.append(System.lineSeparator());
    }

    private void appendSkidMark(Record record) {
        STRING_BUILDER.append(record.getCarName()).append(COLON);

        for (int i = 0; i < record.currentPosition(); ++i) {
            STRING_BUILDER.append(SKID_MARK);
        }

        STRING_BUILDER.append(System.lineSeparator());
    }
}
