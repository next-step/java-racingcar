package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }
        List<String> textTokens = splitText(text);

        return textTokens.stream().mapToInt(StringAddCalculator::toPositive).sum();
    }


    public static List<String> splitText(String text) {
        List<String> seps = new ArrayList<>(List.of(",", ":"));
        if (text.startsWith("//") && text.contains("\n")) {
            String additionalSeparator = text.substring(2, text.indexOf("\n"));
            seps.add(additionalSeparator);
            text = text.substring(text.indexOf("\n") + 1);
        }

        List<String> tokens = List.of(text);
        for (String sep : seps) {
            tokens = splitTextsBySeparator(tokens, sep);
        }

        return tokens;
    }

    public static List<String> splitTextsBySeparator(List<String> texts, String separator) {
        List<String> results = new ArrayList<>();

        for (String text : texts) {
            String[] parts = text.split(separator);
            Collections.addAll(results, parts);
        }

        return results;
    }

    public static int toPositive(String text) throws RuntimeException {
        int number = -1;

        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }

        if (number < 0) {
            throw new RuntimeException();
        }

        return number;
    }
}
