package calculator;

public class Calculator {

    public static String[] strings;
    public static void ThrowRuntimeExceptionIfNegativeValue(int number) throws RuntimeException
    {
        if (number < 0)
        {
            throw new RuntimeException("RuntimeException");
        }
    }

    public static void stringsSplitByDelimiter(String str) {
        if (str.startsWith("//"))    // 요구사항 6
        {
            str = str.replace("//", "");
            str = str.replace("\\n", "");
            String customDelimiter = String.valueOf(str.charAt(0));
            strings = str.split(customDelimiter);
            strings[0] = "0";
        }
        strings = str.split(",|:"); // 요구사항 2, 3, 4, 5
    }

    public static int sum(String str) throws RuntimeException{
        int result = 0;

        if ( (str == null) || (str.isBlank()) ) {  // 요구사항 1
            return 0;
        }

        try {
            stringsSplitByDelimiter(str);
        } catch (Exception exception) {
            throw new RuntimeException("RuntimeException"); // 요구사항 7
        }

        int[] ints = new int[strings.length];
        try {   // 요구사항 7
            for (int i = 0; i < strings.length; i++) {
                ints[i] = Integer.valueOf(strings[i]);
            }
        } catch (Exception exception)
        {
            throw new RuntimeException("RuntimeException");
        }
        for (int i = 0; i < ints.length; i++ ) {
            ThrowRuntimeExceptionIfNegativeValue(ints[i]); // 요구사항 8
            result += ints[i];
        }

        return result;
    }
}
