package calculator;

public class Calculator {

    public static int sum(String str) {
        int result = 0;
        String[] strings;
        if ( (str.equals("")) | (str.equals(null) ) ){
            return 0;
        } else if (str.startsWith("//"))
        {
            str = str.replace("//", "");
            str = str.replace("\\n", "");
            String customDelimiter = String.valueOf(str.charAt(0));
            // str = str.replace(customDelimiter, "");
            strings = str.split( customDelimiter );
            strings[0] = "0";
        } else {
            strings = str.split(",|:");
        }

        for (int i = 0; i < strings.length; i++ ) {
            result += Integer.valueOf(strings[i]);
        }

        return result;
    }
}
