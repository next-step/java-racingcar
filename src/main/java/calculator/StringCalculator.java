package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static int calculate(String text){
        String[] values = text.split(" ");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);

        int[][] temp = new int[values.length/3][3];

        for(int i =1; i <= values.length/3; i++){
            temp[i][0] = Integer.parseInt(values[0]);
            temp[i][1] = Integer.parseInt(values[1]);
            temp[i][2] = Integer.parseInt(values[2]);
        }

        if (values[1].equals("+")){
            return add(first, second);
        }
        if (values[1].equals("-")){
            return subtract(first, second);
        }
        if (values[1].equals("/")){
            return division(first, second);
        }
        if (values[1].equals("*")){
            return multiply(first, second);
        }
        throw new IllegalArgumentException();
    }

    private static int multiply(int first, int second) {
        return first * second;
    }

    private static int division(int first, int second) {
        return first / second;
    }

    private static int add(int first, int second) {
        return first + second;
    }

    private static int subtract(int first, int second) {
        return first - second;
    }

}
