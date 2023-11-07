package step4.input;

import java.util.Scanner;

public class InputView {
    public static UserInput input() {
        Scanner scanner = new Scanner(System.in);

        return new UserInput(inputCarNumber(scanner), inputTryNumber(scanner));
    }

    private static int inputTryNumber(final Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private static int inputCarNumber(final Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }
}
