package calculator;

public class Calculator {
    public static void ThrowRuntimeExceptionIfNegativeValue(int number) throws RuntimeException
    {
        if (number < 0)
        {
            throw new RuntimeException("RuntimeException");
        }
    }
    public static int sum(String str) throws RuntimeException{
        int result = 0;
        String[] strings;

        if ( (str == null) || (str.isBlank()) ) {  // 요구사항 1
            return 0;
        }

        try {
            if (str.startsWith("//"))    // 요구사항 6
            {
                str = str.replace("//", "");
                str = str.replace("\\n", "");
                String customDelimiter = String.valueOf(str.charAt(0));
                strings = str.split(customDelimiter);
                strings[0] = "0";
            } else {    // 요구사항 2, 3, 4, 5
                strings = str.split(",|:");
            }
        } catch (Exception exception) {
            throw new RuntimeException("RuntimeException");
        }

        int[] ints = new int[strings.length];
        try {
            for (int i = 0; i < strings.length; i++) {
                ints[i] = Integer.valueOf(strings[i]);
            }
        } catch (Exception exception)
        {
            throw new RuntimeException("RuntimeException");
        }
        for (int i = 0; i < ints.length; i++ ) {
            ThrowRuntimeExceptionIfNegativeValue(ints[i]);
            result += ints[i];
        }

        return result;
    }
}
