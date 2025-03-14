package racingcar.calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculatorLexer {
    private static final Pattern stringPattern = Pattern.compile("(?://(.)\n)?([\\s\\S]*)");

    public static LexicalAnalyzeResult analyze(String input) {
        if (input == null || input.isEmpty())
            return new LexicalAnalyzeResult();

        Matcher matcher = stringPattern.matcher(input);

        // 정규식이 모든 문자열에 대해 2개의 그룹핑이 나오게 되어 있음
        if (!matcher.find()) // never occurred
            throw new IllegalStateException("Failed to pattern find.");

        return new LexicalAnalyzeResult(matcher.group(1), matcher.group(2));
    }

    public static class LexicalAnalyzeResult {
        private static final String DEFAULT_DELIMITER = ",|:";

        private final String delimiter;
        private final String calcString;

        public LexicalAnalyzeResult() {
            this(DEFAULT_DELIMITER, null);
        }

        public LexicalAnalyzeResult(String delimiter, String calcString) {
            this.delimiter = delimiter != null ? delimiter : DEFAULT_DELIMITER;
            this.calcString = calcString;
        }

        public String getDelimiter() {
            return delimiter;
        }

        public String getCalcString() {
            return calcString;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LexicalAnalyzeResult that = (LexicalAnalyzeResult) o;
            return Objects.equals(delimiter, that.delimiter) && Objects.equals(calcString, that.calcString);
        }

        @Override
        public int hashCode() {
            int result = Objects.hashCode(delimiter);
            result = 31 * result + Objects.hashCode(calcString);
            return result;
        }
    }
}
