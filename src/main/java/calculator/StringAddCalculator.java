package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (StringUtils.isEmpty(input)) {
            return 0;
        }
        String[] tokens = Splitter.split(input);
        int[] numbers = StringParser.toInt(tokens);
        return Numbers.sum(numbers);
    }
}
