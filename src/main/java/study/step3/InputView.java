package study.step3;

import study.step2.StringValidator;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    public static String[] getCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
        String carNames = scanner.nextLine();
        StringValidator.checkCarNameSyntax(carNames);
        return carNames.split(StringValidator.CAR_NAME_SPLIT_DELIMITER);
    }
    public static int getTryCnt(){
        System.out.println("시도할 횟수는 몇회인가요?");
        String tryCnt = scanner.nextLine();
        StringValidator.checkNumberSyntax(tryCnt);
        return Integer.parseInt(tryCnt);
    }
}
