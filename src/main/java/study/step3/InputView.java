package study.step3;

import study.step2.StringValidator;

import java.util.Scanner;

public class InputView {
    public static void input(){
        System.out.println("자동차 대수는 몇대인가요?");
        Scanner scanner = new Scanner(System.in);
        String carCnt = scanner.nextLine();
        StringValidator.checkNumberSyntax(carCnt);
        System.out.println("시도할 횟수는 몇회인가요?");
        String tryCnt = scanner.nextLine();
        StringValidator.checkNumberSyntax(tryCnt);
    }
}
