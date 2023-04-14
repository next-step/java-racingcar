package study.step4;

import java.util.Scanner;

public class InputView {
    public static Scanner scanner = new Scanner(System.in);

    private InputView() {
        // 생성자 내부 호출 -> 명시적 Exception
        throw new AssertionError();
    }

    public static String askCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public static int aksFinishCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
