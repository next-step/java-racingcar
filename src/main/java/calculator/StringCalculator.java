package calculator;

public class StringCalculator {
    public static int calculate(String expression) {
        String[] splitExpression = expression.split(" ");

        int result = 0;

        for(int i=0;i<splitExpression.length;i+=2){
            result += Integer.parseInt(splitExpression[i]);
        }

        return result;
    }
}
