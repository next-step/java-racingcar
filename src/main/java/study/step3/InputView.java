package study.step3;

import study.step2.StringValidator;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    public static int getCarCnt(){
        System.out.println("자동차 대수는 몇대인가요?");
        String carCnt = scanner.nextLine();
        StringValidator.checkNumberSyntax(carCnt);
        return Integer.parseInt(carCnt);
    }
    public static int getTryCnt(){
        System.out.println("시도할 횟수는 몇회인가요?");
        String tryCnt = scanner.nextLine();
        StringValidator.checkNumberSyntax(tryCnt);
        return Integer.parseInt(tryCnt);
    }
}
