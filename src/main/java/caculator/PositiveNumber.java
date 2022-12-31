package caculator;

public class PositiveNumber {
    private final long value;

    public PositiveNumber(final String value) {
        final long parsed = isEmpty(value) ? 0 : parse(value);
        if(parsed < 0) {
            throw new RuntimeException("Negative number type is not supported.");
        }
        this.value = parsed;
    }

    public long getValue() {
        return value;
    }

    private long parse(final String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Unsupported number type.");
        }
    }

    private boolean isEmpty(final String value) {
        return value == null || StringSupport.EMPTY.equals(value);
    }
}
