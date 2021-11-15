package step3;

import java.util.List;

public class ResultView {
    private static final ResultView INSTANCE = new ResultView();
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String UNIT_OF_MOVE = "-";
    private static final int ZERO = 0;
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    private ResultView() {}

    public static ResultView getInstance() {
        return INSTANCE;
    }
    
    public void println(String text) {
        System.out.println(text);
    }

    public void renderRaceResult(List<Record> recordList) {
        recordList.forEach(record -> renderPosition(record));
    }

    private void renderPosition(Record record) {
        STRING_BUILDER.setLength(ZERO);

        record.recordList().stream()
                .forEach(pos -> appendSkid(pos));

        System.out.println(STRING_BUILDER);
    }

    public void renderResultMessage() {
        println(RESULT_MESSAGE);
    }

    private void appendSkid(Position position) {
        for(int i = 0 ; i < position.getPosition(); ++i) {
            STRING_BUILDER.append(UNIT_OF_MOVE);
        }

        STRING_BUILDER.append(System.lineSeparator());
    }
}
