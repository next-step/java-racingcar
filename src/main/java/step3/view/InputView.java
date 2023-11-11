package step3.view;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static String[] askCarNames() {
        String carNamesStr = askStringInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return carNamesStr.split(",");
    }

    public static int askNumberOfAttempts() {
        return askNumericInput("시도할 회수는 몇 회 인가요?");
    }

    private static int askNumericInput(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }

    private static String askStringInput(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

}
