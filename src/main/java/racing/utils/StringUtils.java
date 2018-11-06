package racing.utils;

public abstract class StringUtils {

    private StringUtils() {
    }

    public static String[] split(final String str, final String delimiter) throws IllegalArgumentException {

        if (str == null) {
            throw new IllegalArgumentException();
        }

        if (delimiter == null || "".equals(delimiter)) {
            throw new IllegalArgumentException();
        }

        return str.split(delimiter);
    }

}
