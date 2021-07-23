package util;

import java.util.Objects;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isNumber(String str) {
        return !isEmpty(str) && RegexPattern.NUMBER_PATTERN.matches(str);
    }

    public static boolean isEng(String str) {
        return !isEmpty(str) && RegexPattern.ENG_PATTERN.matches(str);
    }

    public static boolean isEmpty(String str) {
        return Objects.isNull(str) || str.trim().length() == 0;
    }

    private enum RegexPattern {
        NUMBER_PATTERN("^[0-9]+$"),
        ENG_PATTERN("^[a-zA-Z]+$");

        private final String pattern;

        RegexPattern(String pattern) {
            this.pattern = pattern;
        }

        public boolean matches(String str) {
            return Pattern.matches(pattern, str);
        }

        @Override
        public String toString() {
            return pattern;
        }
    }
}
