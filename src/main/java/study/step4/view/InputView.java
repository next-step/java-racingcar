package study.step4.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNameWithComma() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine().replaceAll(" ", "");
    }

    public static String inputNumberOfAttempts(){
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextLine();
    }
}
