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

    private static String[] inputCarNumber(final Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String userInput = scanner.nextLine();
        return userInput.split(",");
    }
}
