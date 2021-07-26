package util;

public class RepeatString {
    private final int number;
    private final String repeatUnit;
    public RepeatString(Number number, String repeatUnit) {
        this.number = number.intValue();
        this.repeatUnit = repeatUnit;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            builder.append(repeatUnit);
        }
        return builder.toString();
    }
}
