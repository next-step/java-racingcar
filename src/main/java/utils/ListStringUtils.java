package utils;

import java.util.List;

public final class ListStringUtils {
    private static final int ZERO = 0;

    public static final boolean isNull(List<String> strings) {
        return strings == null;
    }

    public static final boolean isSizeZero(List<String> strings) {
        return strings.size() == ZERO;
    }

    public static final boolean isNullOrSizeZero(List<String> strings) {
        return (isNull(strings) || isSizeZero(strings));
    }

}
