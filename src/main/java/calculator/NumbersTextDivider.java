package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class NumbersTextDivider {

        private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
        private static final String DEFAULT_DELIMITER_REGAX = ",|:";

        private NumbersTextDivider() {
        }

        public static int[] getSplitNumbers(String text) {
                String[] numberTexts = split(text);
                return getZeroOrMoreNumbersFromNumbersTexts(numberTexts);
        }

        private static String[] split(String text) {
                if (hasCustomDelimiter(text)) {
                        return splitByCustomDelimiter(text);
                }
                return splitByDefaultDelimiter(text);
        }

        private static boolean hasCustomDelimiter(String text) {
                return CUSTOM_DELIMITER_PATTERN.matcher(text).find();
        }

        private static String[] splitByCustomDelimiter(String text) {
                Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
                m.find();
                String customDelimiter = m.group(1);
                return m.group(2).split(customDelimiter);
        }

        private static String[] splitByDefaultDelimiter(String text) {
                return text.split(DEFAULT_DELIMITER_REGAX);
        }

        private static int[] getZeroOrMoreNumbersFromNumbersTexts(String[] texts) {
                return Stream.of(texts).mapToInt(text -> {
                        int number = Integer.parseInt(text);
                        validateNegativeNumber(number);
                        return number;
                }).toArray();
        }

        private static void validateNegativeNumber(int number) {
                if (number < 0) {
                        throw new IllegalArgumentException("0보다 크거나 같은 숫자만 입력 가능합니다.");
                }
        }
}
