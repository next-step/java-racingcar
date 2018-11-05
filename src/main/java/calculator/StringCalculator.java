package calculator;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static int calculator(String text) {
        String[] values = text.split(" ");
        int result = 999999999;
        for(int i=1; i<values.length-1; i+=2) {
            result = parseInt(values[0]);
            result = calculator(values[i], result, parseInt(values[i+1]));
        }
        return result;
    }

    private static int calculator(String value, int first, int second) {
        if (value.equals("+")) {
            return first + second;
        }
        if (value.equals("-")) {
            return first - second;
        }
        if (value.equals("*")) {
            return first * second;
        }
        if (value.equals("/")) {
            return first / second;
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int result = StringCalculator.calculator(text);
        exceptionHandle(result);
    }

    private static void exceptionHandle(int result) {
        if(result == 999999999) {
            System.out.println("잘못된 계산식; 2 + 3 과 같이 입력");
        }
        if(result < 999999999) {
            System.out.println(result);
        }
    }
}