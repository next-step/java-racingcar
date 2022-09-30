package calculator;


import calculator.util.StringUtil;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator
{
    private StringAddCalculator()
    {
        throw new IllegalStateException("Utility class");
    }
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DELIMITER = "[,:]";
    private static final int DEFAULT_RESULT = 0;

    public static int splitAndSum(String value)
    {
        if (StringUtil.isNullOrEmpty(value))
        {
            return DEFAULT_RESULT;
        }
        return Arrays.stream(split(value))
            .map(PositiveNumber::new)
            .reduce(PositiveNumber::plus)
            .get().getNumber();
    }
    private static String[] split(String value)
    {
        String[] splitValue = value.split(DELIMITER);
        Matcher matcher = CUSTOM_PATTERN.matcher(value);
        if (matcher.find())
        {
            String customDelimiter = matcher.group(1);
            splitValue = matcher.group(2).split(customDelimiter);
        }

        return splitValue;
    }
}
