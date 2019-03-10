package calculator;

public class StringCalculator {
    static int calculate(String text) {
        String[] values = text.split(" ");

        int result = 0;
        int arrIndex = 0;
        int calculateCount = values.length/2;

        for ( int i= 0; i< calculateCount; i ++ ) {
            int num1 = 0;
            int num2 = 0;
            String expression = "";

            if ( i == 0 ) {
                result =  Integer.parseInt(values[arrIndex]);
            }

            num1 = result;
            expression = values[arrIndex+1];
            num2 = Integer.parseInt( values[arrIndex+2] );
            result = calculateNum(num1, expression, num2);

            arrIndex += 2;
        }
        return result;
    }


    private static int calculateNum(int num1, String expression, int num2) {
        if("+".equals(expression)) {
            return num1 + num2;
        } if ("-".equals(expression)) {
            return num1 - num2;
        } if ("*".equals(expression)) {
            return num1 * num2;
        } if ("/".equals(expression)) {
            return num1 / num2;
        }

        return 0;
    }
}
