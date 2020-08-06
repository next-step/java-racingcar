package study;

import java.util.Scanner;

public class StringCalculator {

    //연산
    public static int calculate(CalculationType calculator, int num, int result){
        return CalculationType.calculate(calculator, num, result);
    }

    //null값 체크
    public static void checkString(String string){
        if(string==null||string.trim().equals("")){
            throw new IllegalArgumentException();
        }
    }

    //input 값 분리
    public static String[] splitString(String string) {
        String[] stringArray = string.split(" ");
        return stringArray;
    }

    //사칙연산 체크
    public static CalculationType checkCalculation(String inputString) {
        return CalculationType.checkCalculationType(inputString);
    }

    //최종 결과값 얻기
    public static int getResult(String inputString) {
        String[] inputStringArray = splitString(inputString);
        int result = Integer.parseInt(inputStringArray[0]);
        int index = 1;

        while(index < inputStringArray.length){
            CalculationType calculation = checkCalculation(inputStringArray[index]);
            int num = Integer.parseInt(inputStringArray[index+1]);
            result = calculate(calculation, num,  result);
            index = index+2;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("식을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();;

        checkString(inputString);

        System.out.println("결과값은 " + getResult(inputString) + "입니다.");
    }
}
