package step3.ui;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SCANNER.nextLine();
    }

    public static Integer getRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }
}
