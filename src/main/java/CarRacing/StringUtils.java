package CarRacing;

public class StringUtils {
    static final private String BAR = "-";
    static final private String LINE_BREAK = "\n";

    public static String gaugeMaker(int count) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(BAR);
        }

        sb.append(LINE_BREAK);
        return sb.toString();
    }
}
