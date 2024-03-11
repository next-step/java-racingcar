package stringAddCalculator;

import java.util.HashMap;
import java.util.Map;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        return calculate(text);
    }

    private static int calculate(String text) {

        Map<String, String> target = getDelimiterAndText(text);

        String[] numbers = target.get("text").split(target.get("delimiter"));
        int result = 0;

        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    private static boolean isNullOrEmpty(String text) {
        return (text == null) || (text.isEmpty());
    }

    private static Map<String, String> getDelimiterAndText(String text) {
        String delimiter = ",|:";

        if (text.startsWith("//")) {
            delimiter = text.substring(2, text.indexOf("\n"));
            text = text.substring(text.indexOf("\n") + 1);
        }

        HashMap<String, String> result = new HashMap<>();
        result.put("text", text);
        result.put("delimiter", delimiter);

        return result;
    }

}
