package calculator;

public class Calculator {

    public static int sum(String str) {
        int result = 0;

        if ( (str.equals("")) | (str.equals(null) ) ){
            return 0;
        }

        String[] strings = str.split(",|:");
        for (int i = 0; i < strings.length; i++ ) {
            result += Integer.valueOf(strings[i]);
        }

        return result;
    }
}
