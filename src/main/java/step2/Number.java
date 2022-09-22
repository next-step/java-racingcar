package step2;

import step2.util.NumberUtil;

import java.util.Arrays;

public class Number
{
    private final String[] numberStr;

    public Number(String[] numberStr)
    {
        this.numberStr = numberStr;
    }

    public int sum()
    {
        return Arrays.stream(numberStr)
            .mapToInt(NumberUtil::positiveParseInt).sum();
    }
}
