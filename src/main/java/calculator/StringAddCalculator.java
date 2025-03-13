package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if(Util.isEmpty(input)) {
            return 0;
        }
        String[] tokens = StringParser.split(input);
        return StringParser.sum(tokens);
    }
}
