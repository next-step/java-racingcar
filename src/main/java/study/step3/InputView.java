package study.step3;

import study.step2.StringValidator;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String carNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
        String carNames = scanner.nextLine();
        return carNames;
    }

    public int tryCnt(){
        System.out.println("시도할 횟수는 몇회인가요?");
        String tryCnt = scanner.nextLine();
        StringValidator.checkNumberSyntax(tryCnt);
        return Integer.parseInt(tryCnt);
    }
}
