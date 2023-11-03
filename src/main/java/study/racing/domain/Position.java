package study.racing.domain;

public class Position {

    private static final String DASH = "-";
    private static final String NEXT_LINE = "\n";
    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getDash() {

        return DASH.repeat(value) + NEXT_LINE;
    }
}
