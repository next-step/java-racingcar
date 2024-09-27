package calc;

public class StringAddCalculator {

    public static final String REGEX = ",|:";

    public int splitAndSum(String text) {
        if(text.contains(",") || text.contains(":")) {
            return split(text.split(REGEX));
        }
        return Integer.parseInt(text);
    }

    private static int split(String[] splitText) {
        int result = 0;
        for (String s : splitText) {
            result +=Integer.parseInt(s);
        }
        return result;
    }

}
