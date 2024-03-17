package step3.model;

import java.util.List;

public class Record {
    private static final String CAR_POSITION_UNIT = "-";
    private static final String NEXT_LINE_SEPARATOR = System.lineSeparator();
    private final StringBuilder record;

    public Record() {
        this.record = new StringBuilder();
    }


    public void addStage(List<Integer> positions) {
        for (Integer position : positions) {
            record.append(makeHypens(position));
            addNextLine();
        }

        addNextLine();
    }

    public String getRecord() {
        return record.toString();
    }

    private void addNextLine() {
        record.append(NEXT_LINE_SEPARATOR);
    }

    private static String makeHypens(int count) {
        return CAR_POSITION_UNIT.repeat(count);
    }
}
