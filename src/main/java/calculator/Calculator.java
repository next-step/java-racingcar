package calculator;

public class Calculator {

    public static final String DELIMITER = ",|:";
    public static int cal(String text)
    {
        if(isBlank(text))
        {
            return 0;
        }
        return sum(toInts(split(text)));
    }

    private static String[] split(String text)
    {
        if(isCustom(text))
        {
            return customSplit(text);
        }
        return text.split(DELIMITER);
    }

    private static boolean isCustom(String text)
    {
        if(text.split("//|\n").length == 3)
        {
            return true;
        }
        return false;
    }

    private static String[] customSplit(String text)
    {
        String[] textList = text.split("//|\n");
        return textList[2].split(textList[1]);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] numbers)
    {
        includeMinus(numbers);
        int sum = 0;
        for(int number: numbers)
        {
            sum += number;
        }
        return sum;
    }

    private static void includeMinus(int[] numbers)
    {
        try {
            for (int i : numbers)
            {
                System.out.println(i);
                if(i < 0) throw new RuntimeException("DO NOT INPUT MINUS NUMBER");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] toInts(String[] values)
    {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; ++i)
        {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }
}
