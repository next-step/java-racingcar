package CarRacing;

public class StringUtils {
    static final private String BAR = "-";
    static final private String LINE_BREAK = "\n";

    public static String makeGauge(final int count) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(BAR);
        }

        sb.append(LINE_BREAK);
        return sb.toString();
    }

    public static String[] splitStringToStringArr(final String inputString) {
        return inputString.split(",");
    }
}
