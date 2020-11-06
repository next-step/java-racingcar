package utils;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isEmpty(String sampleInput) {
        if (sampleInput == null) {
            return true;
        }
        sampleInput = sampleInput.trim();
        return sampleInput.equals("");
    }

    public static String repeat(final String str, final int repeat) {
        final int inputLength = str.length();
        final int outputLength = inputLength * repeat;

        final StringBuilder buf = new StringBuilder(outputLength);
        for (int i = 0; i < repeat; i++) {
            buf.append(str);
        }
        return buf.toString();

    }
}
