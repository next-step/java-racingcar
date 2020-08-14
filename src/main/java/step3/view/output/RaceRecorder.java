package step3.model;

import java.util.StringJoiner;

public class RaceRecorder {

    private static final String MOVED_PRINTING = "_";
    private static final String NEW_LINE = "\n";
    private static final String WINNER = "우승자: ";
    private StringJoiner source;

    public RaceRecorder() {
        this.source = new StringJoiner("", "", NEW_LINE);
    }

    public void saveRacingRecord(Car car) {
        StringJoiner result = new StringJoiner("", car.getCarName(), NEW_LINE);

        for (int i = 0; i < car.getCarMovedCount(); i++) {
            result.add(MOVED_PRINTING);
        }

        source.add(result.toString());
    }

    public void saveWinners(String result) {
        source.add(WINNER);
        source.add(result);
    }

    public String getResultString() {
        return this.source.toString();
    }

    public void appendNewLine() {
        this.source.add(NEW_LINE);
    }
}
