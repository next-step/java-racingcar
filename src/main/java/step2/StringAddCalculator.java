package step2;


import step2.util.NumberUtil;
import step2.util.StringUtil;

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

        String[] splitValue = StringUtil.split(value, DELIMITER);
        Matcher matcher = CUSTOM_PATTERN.matcher(value);
        if (matcher.find())
        {
            String customDelimiter = matcher.group(1);
            splitValue = StringUtil.split(matcher.group(2), customDelimiter);
        }

        return NumberUtil.sum(splitValue);
    }
}
