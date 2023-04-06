package stringcalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("문자열덧셈계산기");
        System.out.println("----------------");
        System.out.println("기본구분자: ',', ':'");
        System.out.println("커스텀구분자 사용법: //;\\n1;2;3");
        System.out.println("----------------");

        System.out.println("문자열을 입력해주세요: ex) 1:2,3");
        final String text = scanner.next();

        final StringCalculator stringCalculator = new StringCalculator(text);
        System.out.println("정답: " + stringCalculator.sum());
    }

}
