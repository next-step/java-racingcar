package model;

public class RacingRecord {
    private static final String NEW_LINE = System.lineSeparator();
    private final StringBuilder sb;

    public RacingRecord() {
        this.sb = new StringBuilder();
    }

    public void record(Car car) {
        sb.append(car.hyphenatePosition()).append(NEW_LINE);
    }

    public void appendNewLine() {
        sb.append(NEW_LINE);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
