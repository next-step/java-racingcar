package racingGame;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int getTryNo() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException("시도 회수는 숫자로 입력해야 합니다.");
        }
        return scanner.nextInt();
    }
}
