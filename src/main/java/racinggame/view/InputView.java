package racinggame.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String askNumberOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SCANNER.nextLine();
    }

    public static String askNumberOfAttempt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return SCANNER.nextLine();
    }
}
