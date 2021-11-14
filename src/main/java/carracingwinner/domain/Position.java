package carracingwinner.domain;

public final class Position {

    private static final int MIN_POSITION_VALUE = 0;

    private final int intValue;

    public Position() {
        this(0);
    }

    public Position(int value) {
        validateValue(value);
        this.intValue = value;
    }

    private void validateValue(int value) {
        if (value < MIN_POSITION_VALUE) {
            throw new IllegalArgumentException("Position 값은 " + MIN_POSITION_VALUE + "보다 작을 수 없습니다.");
        }
    }

    public Position move() {
        return new Position(intValue + 1);
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intValue; i++) {
            sb.append('-');
        }
        return sb.toString();
    }

}
