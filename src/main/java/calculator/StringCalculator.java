package calculator;

import java.util.ArrayList;

public class StringCalculator {
    static int calculate(String text) {
        String[] values = text.split(" ");
        String symbol = values[1];
        int i = Integer.parseInt(values[0]);
        int j = Integer.parseInt(values[2]);
        int result = 0;

        if(symbol.equals("+")){
            result = add(i ,j );
        }
        if(symbol.equals("-")){
            result = substract(i ,j );
        }
        if(symbol.equals("*")){
            result = multiply(i ,j );
        }
        if(symbol.equals("/")){
            result = divide(i ,j );
        }

        return result;
    }



    static int add(int i, int j) {
        return i + j;
    }

    static int substract(int i, int j) {
        return i - j;
    }

    static int multiply(int i, int j) {
        return i * j;
    }

    static int divide(int i, int j) {
        return i / j;
    }
}
