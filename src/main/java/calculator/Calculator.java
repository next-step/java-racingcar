package calculator;

public class Calculator {

    public static int sum(String str) {
        int result = 0;
        String[] strings = str.split(",|:");
        if ( (str.equals("")) || (str.equals(null) ) ){
            result = 0;
        }
        for (int i = 0; i < strings.length; i++ ) {
            result += Integer.valueOf(strings[i]);
        }

        return result;
    }
}
