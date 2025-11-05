package caculator;

public class StringCalculator {

    public static int splitAndSum(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        String pattern = ",|:";

        if (value.startsWith("//")) {
            int delimiterEndIndex = value.indexOf("\n");
            String customDelimiter = value.substring(2, delimiterEndIndex);
            pattern = pattern + "|" + customDelimiter;
            value = value.substring(delimiterEndIndex + 1);
        }

        String[] result = value.split(pattern);
        
        int sum = 0;

        for (String s : result) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}
