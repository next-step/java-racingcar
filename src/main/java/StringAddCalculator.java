import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class StringAddCalculator {

        private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
        private static final String DEFAULT_DELIMITER_REGAX = ",|:";
        private static final int DEFAULT_NUMBER_ZERO = 0;

        private StringAddCalculator() {
        }

        public static int splitAndSum(String text) {
                if (isEmptyOrNull(text)) {
                        return DEFAULT_NUMBER_ZERO;
                }
                String[] textNumbers = split(text);
                int[] numbers = getZeroOrMoreNumbersFromStrNumbers(textNumbers);
                return sum(numbers);
        }

        private static boolean isEmptyOrNull(String text) {
                return text == null || text.isEmpty();
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

        private static int[] getZeroOrMoreNumbersFromStrNumbers(String[] texts) {
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

        private static int sum(int[] numbers) {
                return IntStream.of(numbers).sum();
        }

}
