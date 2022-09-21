package step2.util;

import step2.exception.NegativeNumberException;

import java.util.Arrays;

public class NumberUtil
{
    private NumberUtil()
    {
        throw new IllegalStateException("Utility class");
    }

    public static int sum(String[] arr)
    {
        return Arrays.stream(arr)
            .mapToInt(NumberUtil::positiveParseInt).sum();
    }

    public static int positiveParseInt(String str)
    {
        int number = Integer.parseInt(str);

        if (number < 0)
        {
            throw new NegativeNumberException();
        }

        return number;
    }
}
