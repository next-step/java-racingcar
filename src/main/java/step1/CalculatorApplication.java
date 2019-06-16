package step1;

import spark.utils.StringUtils;

import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {

        System.out.println("연산하고 싶은 문자열을 입력하세요.");

        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        scan.close();

        int result = operateCalculator(inputString);
        System.out.println("연산 결과 : " + result);
    }

    public static int operateCalculator(String inputString) {
        return 1;
    }

    public static void stringValidation(String inputString) {
        if(StringUtils.isEmpty(inputString)) {
            throw new IllegalArgumentException();
        }
    }

    public static void operatorTypeValidation(String inputType) {
        if(!"+".equals(inputType)
                && !"-".equals(inputType)
                && !"*".equals(inputType)
                && !"/".equals(inputType)) {
            throw new IllegalArgumentException();
        }
    }



}
