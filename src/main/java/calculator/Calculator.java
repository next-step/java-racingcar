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

        if ( (str.equals("")) | (str.equals(null) ) ){  // 요구사항 1
            return 0;
        } else if (str.startsWith("//"))    // 요구사항 6
        {
            str = str.replace("//", "");
            str = str.replace("\\n", "");
            String customDelimiter = String.valueOf(str.charAt(0));
            // str = str.replace(customDelimiter, "");
            strings = str.split( customDelimiter );
            strings[0] = "0";
        } else {    // 요구사항 2, 3, 4, 5
            strings = str.split(",|:");
        }

        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++ ) {
            ints[i] = Integer.valueOf(strings[i]);
        }
        for (int i = 0; i < ints.length; i++ ) {
            ThrowRuntimeExceptionIfNegativeValue(ints[i]);
            result += ints[i];
        }

        return result;
    }
}
