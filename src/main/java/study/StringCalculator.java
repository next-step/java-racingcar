package study;

import java.util.Scanner;

public class StringCalculator {

    public static int plus(int a, int b) {
        return a+b;
    }

    public static int minus(int a, int b) {
        return a-b;
    }

    public static int multiply(int a, int b) {
        return a*b;
    }

    public static int devide(int a, int b) {
        return a/b;
    }

    public static int calculate(String calculation, int num, int result){
        switch (calculation){
            case "+":
                result = plus(num,result);
                break;
            case "-":
                result = minus(num,result);
                break;
            case "*":
                result = multiply(num,result);
                break;
            case "/":
                result = devide(num,result);
                break;
        }
        return result;
    }

    //null값 체크
    public static void stringCheck(String string){
        if(string==null||string.equals("")||string.equals(" ")){
            throw new IllegalArgumentException();
        }
    }

    //input 값 분리
    public static String[] stringSplit(String string) {
        String[] stringArray = string.split(" ");
        return stringArray;
    }

    //사칙연산 체크
    public static String calculationCheck(String inputString) {
        boolean flag = false;
        for(CalculationType type : CalculationType.values()) {
            if(inputString.equals(type.getCalculation())){
                flag = true;
                break;
            }else{
                flag = false;
            }
        }
        if(flag) {
            return inputString;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("식을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();;

        stringCheck(inputString);

        String[] inputStringArray = stringSplit(inputString);
        int result = Integer.parseInt(inputStringArray[0]);
        int index = 1;

        while(index < inputStringArray.length){
            String calculation = calculationCheck(inputStringArray[index]);
            int num = Integer.parseInt(inputStringArray[index+1]);
            result = calculate(calculation, num, result);
            index = index+2;
        }

        System.out.println("결과값은 " + result + "입니다.");
    }
}
