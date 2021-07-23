package step2;

import java.util.Scanner;

public class Calculator {




    /////////////////////

    public static int plus (int num, int result) {
        return result + num;
    }
    public static int minus (int num, int result) {
        return result - num;
    }
    public static int multiply (int num, int result) {
        return result * num;
    }
    public static int divide (int num, int result) {
        return result / num;
    }
    public static String[] splitString (String str) {
        if("".equals(str) || " " == null || str == null) {
            throw new IllegalArgumentException("input 값이 NULL 또는 빈값입니다.");
        }
        return str.split(" ");
    }
    public static int calculator (String[] strArr) {
        String regExp = "^[0-9]+$";

        int result = 0;


        for(int idx = 0; idx < strArr.length; idx++) {

            if(idx == 0) {
                result = Integer.valueOf(strArr[idx]);
            }
            if(idx != 0) {
                if (!strArr[idx].matches(regExp)) {
                    switch (strArr[idx]) {
                        case "+":
                            result = plus(Integer.valueOf(strArr[idx + 1]), result);
                            break;
                        case "-":
                            result = minus(Integer.valueOf(strArr[idx + 1]), result);
                            break;
                        case "*":
                            result = multiply(Integer.valueOf(strArr[idx + 1]), result);
                            break;
                        case "/":
                            result = divide(Integer.valueOf(strArr[idx + 1]), result);
                            break;
                        default:
                            throw new IllegalArgumentException("input값이 사칙연산 기호가 아닙니다.");
                            //break;

                    }
                }
            }


            if(idx == strArr.length - 1) {
                break;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        String[] splitStr = splitString(input.nextLine());

        System.out.println(calculator (splitStr));

    }

}
