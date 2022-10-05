package step3;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 인스턴스 생성 방지
     */
    private InputView() {}

    public static int printAndInputCarQuantity() {
        System.out.println("자동차 대수는 몇대인가요?");
        return scanner.nextInt();
    }

    public static int printAndInputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
