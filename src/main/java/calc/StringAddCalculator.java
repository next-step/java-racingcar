package calc;

public class StringAddCalculator {
    public int splitAndSum(String text) {
        if(text.contains(",")) {
            String[] splitText = text.split(",");
            return split(splitText);
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
