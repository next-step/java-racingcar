package step1;

import java.util.Scanner;
/**
 * 메인클래스: 입력받고, 각 유효성 검사를 호출 및 결과 값 도출
 */

public class InputMain {

    // 1. 사용자 입력을 받는다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 1-1. NullCheck
        ValidationCheck vCheck = new ValidationCheck();
        vCheck.nullCheck(str);

        // 1-2. operatorCheck
        Calculator cal = new Calculator();
        final String[] data = str.split(" ");
        vCheck.numberCheck(data[0]);
        double answer = Integer.parseInt(data[0]);

        for(int i =1; i < data.length; i+=2){
            vCheck.operatorCheck(data[i]);
            vCheck.numberCheck(data[i+1]);
            answer = cal.callCalculate(answer, data[i], Integer.parseInt(data[i+1]));

        }

        System.out.println("연산 결과는 나누기를 고려하여, 소수점 둘째자리까지 출력됩니다.");
        System.out.format("%.2f%n", answer);
    }

}


