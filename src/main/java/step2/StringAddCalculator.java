package step2;


public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) return 0;

        String[] tokens = split(text);
        return sum(tokens);
    }

    public static String[] split(String text) {
        Separator separator = new Separator(text);
        Tokens tokens = new Tokens(text, separator);
        return tokens.value();
    }

    private static int sum(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += new PositiveNumber(token).value();
        }
        return sum;
    }
}
