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
        recordList.forEach(r -> {
            renderPosition(r);
        });
    }

    private void renderPosition(Record record) {
        record.recordList().stream()
                .forEach(p -> {
                    System.out.println(appendText(p.getPosition()));
                });

        System.out.println();
    }

    public void renderResultMessage() {
        println(RESULT_MESSAGE);
    }

    private String appendText(int count) {
        STRING_BUILDER.setLength(ZERO);

        for(int i = 0; i < count; ++i) {
            STRING_BUILDER.append(UNIT_OF_MOVE);
        }

        return STRING_BUILDER.toString();
    }
}
