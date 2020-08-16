package step3.view.output;

import step3.model.Car;

import java.util.StringJoiner;

public class RaceRecorder {

    private StringBuffer source;

    public RaceRecorder() {
        this.source = new StringBuffer();
    }

    public void saveRacingRecord(Car car) {
        StringJoiner result = new StringJoiner("", car.getCarName(), OutputText.NEW_LINE);

        for (int i = 0; i < car.getCarMovedCount(); i++) {
            result.add(OutputText.MOVED_PRINTING);
        }

        source.append(result.toString());
    }

    public void saveWinners(String result) {
        source.append(OutputText.WINNER);
        source.append(result);
    }

    public String getResultString() {
        return this.source.toString();
    }

    public void appendNewLine() {
        this.source.append(OutputText.NEW_LINE);
    }

    public void appendError(String error) { this.source.append(error); }
}
