package step2.util;

public class NumberUtil
{
    private NumberUtil()
    {
        throw new IllegalStateException("Utility class");
    }

    public static int positiveParseInt(String str)
    {
        int number = Integer.parseInt(str);

        if (number < 0)
        {
            throw new IllegalArgumentException();
        }

        return number;
    }
}
