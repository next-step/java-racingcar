package calculator;

public class StringCalculator {
    static int calculate(String text){
        String[] strs = text.split("");

        int a = 0;
        int b = 0;
        for (int i = 0; i < strs.length; i++) {

        }

        return 0;
    }

    static int calculator(int i, int j, String expression){
        if(expression.equals("+"))
            return i + j;
        if(expression.equals("-"))
            return i - j;
        if(expression.equals("*"))
            return i * j;
        if(expression.equals("/"))
            return i / j;
    }
}
