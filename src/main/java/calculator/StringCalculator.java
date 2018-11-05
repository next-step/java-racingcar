package calculator;

import java.util.Scanner;

public class StringCalculator {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int result = calculate(value);
        System.out.println("result : " + result);
    }
    public static int calculate(String text) {
        String[] values = text.split(" ");

        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);
        int result = detailCalculate(values[1], first, second);


        text = getSubstring(text);
        text = result + text;


        if (values.length <= 3) {
            return result;
            //여기서 리턴 받은 값으로 다시 text를 만들어 그리고 calculate 함수를 다시 돌려!
        }
        return calculate(text);
    }

    public static String getSubstring(String text) {
        return text.substring(5);
    }

    private static int detailCalculate(String value, int first, int second) {
        if(value.equals("+")){
            return first + second;
        }
        if(value.equals("-")){
            return first - second;
        }
        if(value.equals("*")){
            return first*second;
        }
        if(value.equals("/")){
            return first/second;
        }
            return 0;
    }

}
