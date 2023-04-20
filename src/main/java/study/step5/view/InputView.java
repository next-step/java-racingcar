package study.step5.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        // 생성자 내부 호출 -> 명시적 Exception
        throw new AssertionError();
    }

    public static String askCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SCANNER.next();
    }

    public static int aksAttemptCountCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return SCANNER.nextInt();
    }
}
