package step2;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        SplitMatcher splitMatcher = SplitMatcher.of(text);
        if (splitMatcher.find()) {
            return PositiveNumbers.of(Delimiter.of(splitMatcher.getSplit()).split(splitMatcher.getText())).sum();
        }
        return PositiveNumbers.of(Delimiter.of().split(text)).sum();
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
}
