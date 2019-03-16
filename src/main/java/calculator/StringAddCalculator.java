package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    static Positive calc(String inputText) {
        if (StringUtils.isEmpty(inputText)) {
            return new Positive(0);
        }

        return addAll(split(inputText));
    }

    private static Positive addAll(List<Positive> numbers) {
        Positive positive = new Positive(0);

        for (Positive number : numbers) {
            positive = number.add(positive);
        }

        return positive;
    }

    private static List<Positive> split(final String inputText, final String delimiter) {
        String[] inputNums = inputText.split(delimiter);
        List<Positive> numbers = new ArrayList<>();

        for (String inputNum : inputNums) {
            numbers.add(new Positive(Integer.parseInt(inputNum)));
        }

        return numbers;
    }

    static List<Positive> split(final String inputText) {
        String delimiter = ",|:";

        String customDelimiterRegex = "\\/\\/([\\W])\\\n";
        Pattern delimiterPattern = Pattern.compile(customDelimiterRegex);
        Matcher delimiterMatcher = delimiterPattern.matcher(inputText);

        if (delimiterMatcher.find()){
            return split(inputText.substring(4), delimiterMatcher.group(1));
        }

        return split(inputText, delimiter);
    }
}
